package microjs.jcompiler.frontend.ast;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KCons;
import microjs.jcompiler.utils.DotGraph;

public class Cons extends Expr {
    private Expr car;
    private Expr cdr;
    
    public Cons(Expr car, Expr cdr, Location startPos, Location endPos) {
    	super(startPos, endPos);
        this.car = car;
        this.cdr = cdr;
    }
    
    @Override
    public KCons expand() {
        return new KCons(car.expand(), cdr.expand(), getStartPos(), getEndPos());
    }
    
	@Override
	protected String buildDotGraph(DotGraph graph) {
		return graph.addNode("cons(" + car + ", " + cdr + ")");
		
	}
	@Override
	protected void prettyPrint(StringBuilder buf) {
		buf.append("cons(");    	    	
    	buf.append(car);    	
        buf.append(", ");
        buf.append(cdr);    	
    	buf.append(")");
	}
}
