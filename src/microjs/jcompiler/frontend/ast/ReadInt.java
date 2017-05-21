package microjs.jcompiler.frontend.ast;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KReadInt;
import microjs.jcompiler.utils.DotGraph;

public class ReadInt extends Expr {
	
	public ReadInt(Location startPos, Location endPos) {
		super(startPos, endPos);
	}
	
	@Override
	public KReadInt expand() {
		return new KReadInt(getStartPos(), getEndPos());
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
