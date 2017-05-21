package microjs.jcompiler.frontend.ast;

import java.util.List;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KWhile;
import microjs.jcompiler.middleend.kast.KSeq;
import microjs.jcompiler.middleend.kast.KStatement;
import microjs.jcompiler.utils.DotGraph;

public class While extends Statement {
    private Expr cond;
    private List<Statement> body;
    
    public While(Expr cond, List<Statement> body, Location startPos, Location endPos) {
    	super(startPos, endPos);		
    	this.cond = cond;
    	this.body = body;
    }
    
    @Override
    public KWhile expand() {
        KStatement b = KSeq.buildKSeq(Statement.expandStatements(body), getStartPos(), getEndPos());
        return new KWhile(cond.expand(), b, getStartPos(), getEndPos());
    }

    @Override
	protected String buildDotGraph(DotGraph graph) {
		return "";
	}

    protected void prettyPrint(StringBuilder buf, int indent_level){
        //TODO:
    }
}
