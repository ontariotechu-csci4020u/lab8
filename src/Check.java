import numlang.*;

public class Check {
    public static void print(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    /**
     * Evaluates an expression
     * using an empty context.
     */
    public static void eval(Expr e) {
        eval(e, new Context());
    }

    /**
     * Evaluates an expression
     * using a given context
     */
    public static void eval(Expr e, Context c) {
        try {
            print("%s\n=> %.2f", e, e.evaluate(c));
        } catch(Exception err) {
            print("%s\n[err] %s", e, err.getMessage());
        }
    }

    /**
     * Checks literals
     *
     * 3.1415
     */
    public static void check1() {
        Expr e = new Literal(3.1415);
        eval(e);
    }

    /**
     * Checks arithmetics
     *
     * 3.1415 * (10.2 * 10.2)
     */
    public static void check2() {
        Expr e = new Arith("mult",
                    new Literal(3.1415),
                    new Arith("mult", 
                        new Literal(10.2),
                        new Literal(10.2)));

        eval(e);
    }

    /**
     * Checks error handling for bad arithmetics
     *
     * (blah 3.1415 45.0)
     */
    public static void check3() {
        Expr e = new Arith("blah",
                    new Literal(3.1415),
                    new Literal(45.0));
        eval(e);
    }

    /**
     * Check variables and assignments
     *
     * pi = 3.1415
     * r = 10.2
     * pi * (r * r)
     */
    public static void check4() {
        // Variable and assignment
        Context c = new Context();
        eval(new Assign("pi", new Literal(3.1415)), c);
        eval(new Assign("r", new Literal(10.2)), c);
        eval(new Arith("mult",
                    new Var("pi"),
                    new Arith("mult",
                        new Var("r"),
                        new Var("r"))), c);
    }

    /**
     * Check error handling for variables
     *
     * pi
     */
    public static void check5() {
        eval(new Var("pi"));
    }

    /**
     * Check branching
     *
     * r = 99
     * if r lt 100 then -1 else 1
     * 
     * r = 101
     * if r lt 100 then -1 else 1
     */
    public static void check6() {
        // Branching with if-else
        Context c = new Context();
        Expr e = new IfElse(
                    new Cond("lt", new Var("r"), new Literal(100)),
                    new Literal(-1),
                    new Literal(1));

        eval(new Assign("r", new Literal(99)), c);
        eval(e, c);

        eval(new Assign("r", new Literal(101)), c);
        eval(e, c);
    }

    /**
     * Check block
     *
     * pi = 3.1415
     * r = 10.2
     * area = pi * (r * r)
     * area + area
     */
    public static void check7() {
        eval(
            new Block(new Expr[] {
                new Assign("pi", new Literal(3.1415)),
                new Assign("r", new Literal(10.2)),
                new Assign("area",
                        new Arith("mult",
                            new Var("pi"),
                            new Arith("mult",
                                new Var("r"), new Var("r")))),
                new Arith("plus",
                        new Var("area"),
                        new Var("area"))
            }));
    }

    /**
     * Check while loop
     *
     * i = 0
     * sum = 0
     * while i lt 100 {
     *   sum = sum + i
     *   i = i + 1
     * }
     * sum
     */
    public static void check8() {
        eval(
            new Block(new Expr[] {
                new Assign("i", new Literal(0)),
                new Assign("sum", new Literal(0)),
                new WhileLoop(
                    new Cond("lt",
                        new Var("i"),
                        new Literal(100)),
                    new Block(new Expr[]{
                        new Assign("sum",
                            new Arith("plus",
                                new Var("sum"),
                                new Var("i"))),
                        new Assign("i",
                            new Arith("plus",
                                new Var("i"),
                                new Literal(1)))
                    })),
                new Var("sum")
            }));
    }

    /**
     * Check function declaration and invocation
     *
     * def add(i, j):
     *   i + j
     *
     * add(100, 200)
     */
    public static void check9() {
        eval(
            new Block(new Expr[]{
                new FuncDecl("add", 
                        new String[]{"i", "j"},
                        new Arith("plus",
                            new Var("i"), 
                            new Var("j"))),
                new FuncInvoke("add", new Expr[]{
                    new Literal(100), 
                    new Literal(200)
                }),
            }));
    }

    /**
     * Check for error handling in function invocation
     *
     * blah(10, 20)
     */
    public static void check10() {
        eval(new FuncInvoke("blah", new Expr[]{}));
    }

    /**
     * Check for error handling in function invocation
     * with incorrect number of arguments.
     *
     * def add(i,j):
     *   i+j
     *
     * add(10, 20, 30)
     */
    public static void check11() {
        eval(
            new Block(new Expr[]{
                new FuncDecl("add", 
                        new String[]{"i", "j"},
                        new Arith("plus",
                            new Var("i"), 
                            new Var("j"))),
                new FuncInvoke("add", new Expr[]{
                    new Literal(10), 
                    new Literal(20),
                    new Literal(30)
                }),
            }));
    }

    /**
     * Check recursion
     *
     * def fib(n):
     *   if n le 2:
     *     1
     *   else:
     *     fib(n-1) + fib(n-2)
     *
     * fib(20)
     */
    public static void check12() {
        eval(
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
            }));
    }
            

    public static void main(String[] args) {
        check1();
        check2();
        check3();
        check4();
        check5();
        check6();
        check7();
        check8();
        check9();
        check10();
        check11();
        check12();
    }
}
