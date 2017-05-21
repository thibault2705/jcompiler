package microjs.jcompiler.frontend.ast;

import microjs.jcompiler.middleend.kast.KCar;
import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.utils.DotGraph;

public class Car extends Expr{
    private Expr expr;
    
    public Car(Expr expr, Location startPos, Location endPos){
        super(startPos, endPos);        
        this.expr = expr;
    }
    
    @Override
    public KCar expand(){
        return new KCar(expr.expand(), getStartPos(), getEndPos());
    }
    
    @Override
    protected String buildDotGraph(DotGraph graph){
        return " ";
    }

    @Override
    protected void prettyPrint(StringBuilder buf){
        buf.append("car(");
        expr.prettyPrint(buf);
        buf.append(")");
    }
}
