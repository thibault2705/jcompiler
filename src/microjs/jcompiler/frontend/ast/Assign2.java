package microjs.jcompiler.frontend.ast;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KAssign2;
import microjs.jcompiler.utils.DotGraph;

public class Assign2 extends Statement {
    private String varName;
    private String op;
    private Expr expr;
    
    public Assign2(String varName, String op, Expr expr, Location startPos, Location endPos) {
        super(startPos, endPos);        
        this.varName = varName;
        this.op = op;
        this.expr = expr;
    }
    
    @Override
    public KAssign2 expand() {
        return new KAssign2(varName, op, expr.expand(), getStartPos(), getEndPos());
    }

    @Override
    protected void prettyPrint(StringBuilder buf, int indent_level) {
        indent(buf, indent_level);
        buf.append(varName);
        switch (op) {
            case "+=" : buf.append(" += "); break;
            case "-=" : buf.append(" -= "); break;
            case "*=" : buf.append(" *= "); break;
            case "/=" : buf.append(" /= "); break;
            default: buf.append(" none" ); break;
        }
        expr.prettyPrint(buf);
    }

    @Override
	protected String buildDotGraph(DotGraph graph) {
		return "";
	}
}