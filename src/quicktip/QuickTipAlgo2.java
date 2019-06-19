package quicktip;

import java.util.List;

import main.GamePanel;

public class QuickTipAlgo2 implements QuickTip {

	QuickTipAlgo2() {

	}

	@Override
	public GamePanel QuickTipGeneratorOne(int numberIntervalMax, int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<GamePanel> QuickTipGeneratorTwo(int numberOfGamePanels, int numberOfGeneratedValues) {
		return RandomGeneratorUtil.INSTANCE.generate(this, numberOfGamePanels, numberOfGeneratedValues);
	}

	@Override
	public List<GamePanel> QuickTipGeneratorThree(int numberOfGamePanels, int numberIntervalMax,
			int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

}
