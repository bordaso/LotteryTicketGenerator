package quicktip;

import java.util.List;

import main.GamePanel;

public class QuickTipAlgo1 implements QuickTip{
	
	
	QuickTipAlgo1(){
		
	}

	@Override
	public GamePanel QuickTipGeneratorOne(int maxGeneratedNumberValue, int numberOfGeneratedValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GamePanel> QuickTipGeneratorTwo(int numberOfGamePanels, int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<GamePanel> QuickTipGeneratorThree(int numberOfGamePanels, int maxGeneratedNumberValue,
			int numberOfGeneratedValues) {
		throw new UnsupportedOperationException();
	}

}
