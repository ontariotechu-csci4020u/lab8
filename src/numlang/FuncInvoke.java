package numlang;

public class FuncInvoke extends Expr {
    String name;
    Expr[] exprList;

    public FuncInvoke(String name, Expr[] args) {
        this.name = name;
        this.exprList = args;
    }

    public Double evaluate(Context ctx) throws Exception {
        // To be completed
        return 0.0;
    }

    public String toString() {
        String args;
        if(this.exprList.length == 0) {
            args = "";
        } else {
            args = this.exprList[0].toString();
            for(int i=1; i < this.exprList.length; i++)
                args += "," + this.exprList[i];
        }
        return String.format("%s(%s)", this.name, args);
    }
}
