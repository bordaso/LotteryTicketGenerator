package main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import quicktip.QuickTipFacade;


public class LotteryCorp {

	public static void main(String[] args) throws Exception {
		
		String[] argsTest= {"7","3"};
		args=argsTest;

		List<Integer> instructions = Arrays.asList(args).stream().mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());

		List<GameTicket> finalVals = QuickTipFacade.getQtfacade().callProperQuickTipGenerator(instructions.get(0), instructions.get(1));
	
		IntStream.rangeClosed(0, finalVals.size()-1)
		.forEach(e-> finalVals.get(e).getPlayedPanels().stream().flatMap(ppl-> ppl.stream()).forEach(ee->System.out.println(ee.getNumbers())));
}

}
