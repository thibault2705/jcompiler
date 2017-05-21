package microjs.jcompiler.middleend.kast;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class KCons extends KExpr {
    private KExpr car; 
    private KExpr cdr;
	
	public KCons(KExpr car, KExpr cdr, Location startPos, Location endPos) {
		super(startPos, endPos);
        this.car = car;
        this.cdr = cdr;
	}
	
	@Override
    public void accept(KASTVisitor visitor) {
    	visitor.visit(this);
    }

    public KExpr getCar() {
        return car;
    }

    public KExpr getCdr() {
        return cdr;
    }
}
