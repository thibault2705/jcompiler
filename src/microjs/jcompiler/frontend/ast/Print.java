package microjs.jcompiler.frontend.ast;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KPrint;
import microjs.jcompiler.utils.DotGraph;

public class Print extends Expr {
    private Expr expr;
	
	public Print(Expr expr, Location startPos, Location endPos) {
		super(startPos, endPos);
        this.expr = expr;
	}
	
	@Override
	public KPrint expand() {
        return new KPrint(expr.expand(), getStartPos(), getEndPos());
	}

	@Override
	protected String buildDotGraph(DotGraph graph) {
		return "";
	}

	@Override
	protected void prettyPrint(StringBuilder buf) {
		// todo
	}
}
