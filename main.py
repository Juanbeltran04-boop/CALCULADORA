import sys
from antlr4 import *
from CalculatorLexer import CalculatorLexer
from CalculatorParser import CalculatorParser

def main():
    while True:
        try:
            input_expr = input("Ingrese una expresión (o 'salir' para terminar): ")
            if input_expr.lower() == "salir":
                break

            input_stream = InputStream(input_expr + "\n")
            lexer = CalculatorLexer(input_stream)
            tokens = CommonTokenStream(lexer)
            parser = CalculatorParser(tokens)
            parser.prog()  # Evalúa e imprime resultado con `print($expr.value)`

        except Exception as e:
            print("Error:", e)

if __name__ == "__main__":
    main()

