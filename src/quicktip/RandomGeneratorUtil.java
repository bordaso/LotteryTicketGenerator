package quicktip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import main.GamePanel;

public class RandomGeneratorUtil {
	
	static final RandomGeneratorUtil INSTANCE = new RandomGeneratorUtil();
	private List<GamePanel> filledPanels;
	
	private RandomGeneratorUtil() {		
	}
	
	List<GamePanel> generate(QuickTip quicktip, int ...inputs){
		
		filledPanels = new ArrayList<>();
		int inputLength = inputs==null?0:inputs.length;
		
		switch (inputLength) {
		case 2:
		decider(quicktip, inputs);			
		return filledPanels;
		case 3:
			longStreamCaller(inputs[0], inputs[2], inputs[1]);			
			return filledPanels;
		default:
			throw new UnsupportedOperationException();
		}		
	}
	
	
	private void decider(QuickTip quicktip, int ...inputs) {
		
		if(quicktip instanceof QuickTipAlgo2) {				
			longStreamCaller(inputs[0], inputs[1], 91);
			return;			
		}
		
		GamePanel gpForAlg1 = new GamePanel();		
		IntStream.rangeClosed(1, inputs[1])
				.forEach(e-> gpForAlg1.getNumbers().add(ThreadLocalRandom.current().nextInt(1, inputs[0])));
		
		filledPanels.add(gpForAlg1);
	}
	
	private void longStreamCaller(int a, int b, int c) {
		
		filledPanels =	IntStream.rangeClosed(1, a)
				.mapToObj(e-> new GamePanel())
				.peek(eo-> IntStream.rangeClosed(1, b)
								.forEach(ei->{ eo.getNumbers().add(ThreadLocalRandom.current().nextInt(1, c));})
				).collect(Collectors.toList());		
	}

}
