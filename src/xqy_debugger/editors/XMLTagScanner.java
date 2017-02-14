package xqy_debugger.editors;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

public class XMLTagScanner extends RuleBasedScanner {

	public XMLTagScanner(ColorManager manager) {
		IToken string = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.STRING)));
		IToken procInstr = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.PROC_INSTR)));
		IToken var = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.VAR)));


		IRule[] rules = new IRule[5];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\');
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());
		//Add rule for processing instructions
		rules[3] = new SingleLineRule("<?", "?>", procInstr);
		//Add rule for processing instructions
		rules[4] = new WordPatternRule(new XqyWordDetector(), "$", null, var);

		setRules(rules);
	}
}
