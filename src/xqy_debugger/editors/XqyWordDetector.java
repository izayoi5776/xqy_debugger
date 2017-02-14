package xqy_debugger.editors;

import org.eclipse.jface.text.rules.IWordDetector;

public class XqyWordDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		// TODO Auto-generated method stub
		if((c >='A' && c <= 'Z') || (c >='a' && c <= 'z'))
			return true;
		else return false;
	}

	@Override
	public boolean isWordPart(char c) {
		if((c >='A' && c <= 'Z') || (c >='a' && c <= 'z') || (c >='0' && c <= '9'))
			return true;
		else return false;
	}

}
