package numlang;

public abstract class Expr {
    abstract public Double evaluate(Context context) throws Exception;
    
    @Override
    public String toString() {
        return "toString() not implemented yet.";
    }
}
