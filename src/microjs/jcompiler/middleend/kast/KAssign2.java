package microjs.jcompiler.middleend.kast;

import java_cup.runtime.ComplexSymbolFactory.Location;
public class KAssign2 extends KStatement {
    private String varName, op;
    private KExpr expr;
    
    public KAssign2(String varName, String op, KExpr expr, Location startPos, Location endPos) {
    	super(startPos, endPos);		
    	this.varName = varName;
        this.op = op;
		this.expr = expr;
    }

    @Override
    public void accept(KASTVisitor visitor) {
    	visitor.visit(this);
    }

    public String getVarName() {
        return varName;
    }

    public String getOp() {
        return op;
    }
	
	public KExpr getExpr() {
		return expr;
	}

}
