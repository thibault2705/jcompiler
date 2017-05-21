package microjs.jcompiler.middleend.kast;

import java.util.List;

import java_cup.runtime.ComplexSymbolFactory.Location;

public class KWhile extends KStatement {
    private KExpr cond;
    private KStatement body;

    public KWhile(KExpr cond, KStatement body, Location startPos, Location endPos) {
    	super(startPos, endPos);		
    	this.cond = cond;
        this.body = body;
    }
    
    @Override
    public void accept(KASTVisitor visitor) {
    	visitor.visit(this);
    }

	public KExpr getCond() {
		return cond;
	}
	
	public KStatement getBody() {
        return body;
    }


}
