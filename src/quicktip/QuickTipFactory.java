package quicktip;

public class QuickTipFactory {
	
	private static final QuickTipFactory INSTANCE = new QuickTipFactory();
	
	private QuickTipFactory() {		
	}

	static QuickTipFactory getInstance() {
		return INSTANCE;
	}
	
	QuickTip quickTipAlgoSwitcher(int algoNum) {
		
		QuickTip algoInst;
		
		switch (algoNum) {
		case 1:
			algoInst=new QuickTipAlgo1();
			return algoInst;
		case 2:
			algoInst=new QuickTipAlgo2();
			return algoInst;
		case 3:
			algoInst=new QuickTipAlgo3();
			return algoInst;
		default:
			throw new UnsupportedOperationException();
		}		
	}
}
