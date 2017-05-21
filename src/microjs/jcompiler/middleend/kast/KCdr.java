package microjs.jcompiler.middleend.kast;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class KCdr extends KExpr{
    private KExpr expr;
    
    public KCdr(KExpr expr, Location startPos, Location endPos){
        super(startPos, endPos);
        this.expr = expr;
    }

    @Override
    public void accept(KASTVisitor visitor){
        visitor.visit(this);
    }
    
    public KExpr getExpr(){
        return expr;
    }
}
