# Lab 8: A Java Backend For A Turing Complete Programming Language

In this lab, you will be _completing_ an implementation of the Java backend of a programming language over _doubles_.
The programming language has the following constructs:

- Literals,
- Variable reference
- Variable assignment
- Function declaration
- Function invocation
- Built-in arithmetics
- Branching
- While loops

## Introduction

All of the programming constructs are implemented as Java classes in a package called `numlang`. We provide a base abstract class: `Expr`.

```java
abstract class Expr {
  abstract public Double evaluate(Context ctx) throws Exception;
  @Override
  public String toString() {
    ...
  }
} 
```

Observe:

1. `Expr` objects must be able to evaluate themselves to a _double_ object for a given _context_.
2. `Expr` objects can render themselves as strings.  This is provided for you already, so you don't need to
worry about how to convert `Expr` to strings.

**Your task is to provide the implementation of the _evaluate_ method for each of the programming constructs.**

## Code provided

You are provided the skeleton code for all the programming constructs.  You need to fill in the _evaluate_ method.

There is a `Check.java` file which contains several test cases to test your implementation.  The test cases vary from simple to complex programs.  The last program is a recursive implementation of the Fibonacci numbers.

In pseudo code, the program looks like:

```python
def fib(n):
  if n <= 2:
    return 1
  else:
    return fib(n-1) + fib(n-2)
```

When we translate this to the Java backend, it looks like this:

```java
new Block(new Expr[]{
    new FuncDecl("fib",
        new String[]{"n"},
        new IfElse(
            new Cond("le",
                new Var("n"),
                new Literal(2)),
            new Literal(1),
            new Arith("plus",
                new FuncInvoke("fib",
                    new Expr[]{
                        new Arith("sub",
                            new Var("n"),
                            new Literal(1))
                    }),
                new FuncInvoke("fib",
                    new Expr[]{
                        new Arith("sub",
                            new Var("n"),
                            new Literal(2))
                    })))),
    new FuncInvoke("fib",
        new Expr[]{
            new Literal(20)
        })
```

This program should evaluate to the correct value for the 20th Fibonacci number: 6765.

## Makefile

A `Makefile` is provided to simply your development:

- `make java` compiles the code.
- `make check` checks against all test cases.
