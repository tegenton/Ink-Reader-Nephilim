from sys import argv


class Node():
    def __init__(self, letter):
        self.__letter = letter
        self.__children = {}
        self.__product = None

    def add(self, string, product):
        if len(string) == 0:
            self.__product = product
            return
        char = string[0]
        string = string[1:]
        if char not in self.__children:
            self.__children[char] = Node(char)
        self.__children[char].add(string, product)

    def __str__(self):
        string = self.__letter + "["
        for child in self.__children.values():
            string = string + str(child)
        return string + "]"

    def getProduct(self):
        return self.__product

    def getTransitions(self):
        return self.__children

def output(file, node, state):
    line = ""
    if node.getProduct() is not None:
        line = f"MAP.put(\"{state}\", TransitionFactory.mapOf({node.getProduct()}, "
    else:
        line = f"MAP.put(\"{state}\", TransitionFactory.mapOf("
    for key in node.getTransitions().keys():
        line = line + f"'{key}', "
    file.write(line[:-2] + "));\n")
    for key, value in node.getTransitions().items():
        output(file, value, state + key)

def main():
    if len(argv) != 2:
        print("bad args")
        return
    try: 
        file = open(argv[1])
    except OSError:
        print("Unable to open file: " + argv[1])
        return
    print("using " + argv[1] + " to generate productions")
    productions = file.readlines();
    file.close()
    root = Node(productions[0][0])
    for production in productions:
        string, enum = production.strip().split(",")
        print(string + " should produce " + enum)
        root.add(string[1:], enum)
    print(root)
    file = open("tmp.txt", "w")
    output(file, root, productions[0][0:1])
    file.close()

if __name__ == "__main__":
    main()
