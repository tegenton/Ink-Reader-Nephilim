from sys import argv

def output(file, string, enum):
    file.write("@Test\nvoid " + string.lower() + "() {\ninput = \"" + string + "\";\nexpected = " + enum + ";\n}\r\n")

def main():
    if len(argv) != 2:
        print("bad args")
        return
    try: 
        file = open(argv[1])
    except OSError:
        print("Unable to open file: " + argv[1])
        return
    productions = file.readlines();
    file.close()
    file = open("tmpt.txt", "w")
    for production in productions:
        string, enum = production.strip().split(",")
        output(file, string, enum)
    file.close()

if __name__ == "__main__":
    main()
