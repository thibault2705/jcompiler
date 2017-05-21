package microjs.jcompiler.middleend.kast;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class KCar extends KExpr{
    private KExpr expr;
    
    public KCar(KExpr expr, Location startPos, Location endPos){
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
