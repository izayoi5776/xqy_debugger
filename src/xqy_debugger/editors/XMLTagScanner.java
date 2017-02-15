package xqy_debugger.editors;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

public class XMLTagScanner extends RuleBasedScanner {

	public XMLTagScanner(ColorManager manager) {
		IToken string1 = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.XQY_STRING1)));
		IToken string2 = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.XQY_STRING2)));
		IToken procInstr = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.PROC_INSTR)));
		IToken var = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.XQY_VAR)));
		IToken number = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.XQY_NUMBER)));


		IRule[] rules = new IRule[6];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string2, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string1, '\\');
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());
		//Add rule for processing instructions
		rules[3] = new SingleLineRule("<?", "?>", procInstr);
		// Add rule for $var
		rules[4] = new WordPatternRule(new XqyWordDetector(), "$", null, var);
		// Add rule for number
		rules[5] = new NumberRule(number);
		// TODO keyword rule
		// TODO symble rule
		

		setRules(rules);
	}
}
