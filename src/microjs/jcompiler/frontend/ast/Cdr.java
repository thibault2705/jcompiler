package microjs.jcompiler.frontend.ast;

import microjs.jcompiler.middleend.kast.KCdr;
import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.utils.DotGraph;

public class Cdr extends Expr{
    private Expr expr;
    
    public Cdr(Expr expr, Location startPos, Location endPos){
        super(startPos, endPos);        
        this.expr = expr;
    }
    
    @Override
    public KCdr expand(){
        return new KCdr(expr.expand(), getStartPos(), getEndPos());
    }
    
    @Override
    protected String buildDotGraph(DotGraph graph){
        return " ";
    }

    @Override
    protected void prettyPrint(StringBuilder buf){
        buf.append("cdr(");
        expr.prettyPrint(buf);
        buf.append(")");
    }
}
