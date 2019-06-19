package quicktip;

import java.util.List;

import main.GamePanel;

public class QuickTipAlgo1 implements QuickTip{
	
	
	QuickTipAlgo1(){		
	}

	@Override
	public GamePanel QuickTipGeneratorOne(int numberIntervalMax, int numberOfGeneratedValues) {
		return RandomGeneratorUtil.INSTANCE.generate(this, numberIntervalMax, numberOfGeneratedValues).get(0);
	}

	@Override
	public List<GamePanel> QuickTipGeneratorTwo(int numberOfGamePanels, int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<GamePanel> QuickTipGeneratorThree(int numberOfGamePanels, int numberIntervalMax,
			int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

}
