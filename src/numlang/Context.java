package numlang;

import java.util.*;

public class Context extends HashMap<String, DoubleOrFuncDecl> {
    public Context() {
        super();
    }
    public Context copy() {
        Context c = new Context();
        for(String k : this.keySet()) {
            c.put(k, this.get(k));
        }
        return c;
    }
}
