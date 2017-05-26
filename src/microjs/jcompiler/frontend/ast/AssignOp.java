package microjs.jcompiler.frontend.ast;

import java.util.List;
import java.util.ArrayList;

import java_cup.runtime.ComplexSymbolFactory.Location;
import microjs.jcompiler.middleend.kast.KAssign;
import microjs.jcompiler.middleend.kast.KEVar;
import microjs.jcompiler.middleend.kast.KCall;
import microjs.jcompiler.middleend.kast.KExpr;
import microjs.jcompiler.utils.DotGraph;

public class AssignOp extends Statement {
    private String name;
    private String op;
    private Expr expr;
    
    public AssignOp(String name, String op, Expr expr, Location startPos, Location endPos) {
        super(startPos, endPos);        
        this.name = name;
        this.op = op;
        this.expr = expr;
    }
    
    @Override
    public KAssign expand() {
		List<KExpr> args = new ArrayList<KExpr>();

		args.add(new KEVar(name, getStartPos(), getEndPos()));
		args.add(expr.expand());

		KEVar var = new KEVar(op.substring(0, 1), getStartPos(), getEndPos());

		KCall call = new KCall(var, args, getStartPos(), getEndPos());

    	return new KAssign(name, call, getStartPos(), getEndPos());
    }

    @Override
    protected void prettyPrint(StringBuilder buf, int indent_level) {
        indent(buf, indent_level);
        buf.append(name);
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
		String assignNode = graph.addNode("AssignBis[" + name + ", " + op + "]");
		String exprNode = expr.buildDotGraph(graph);
		graph.addEdge(assignNode, exprNode, "expr");	
		return assignNode;
	}
}