package quicktip;

import java.util.List;

import main.GamePanel;

public interface QuickTip {
	
	public GamePanel QuickTipGeneratorOne(int numberIntervalMax, int numberOfGeneratedValues);
	public List<GamePanel> QuickTipGeneratorTwo(int numberOfGamePanels, int numberOfGeneratedValues);
	public List<GamePanel> QuickTipGeneratorThree(int numberOfGamePanels, int numberIntervalMax, int numberOfGeneratedValues);
}
