package quicktip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.GamePanel;
import main.GameTicket;

public class QuickTipFacade {

	private final QuickTip algo1;
	private final QuickTip algo2;
	private final QuickTip algo3;
	
	private List<Integer> params = new ArrayList<>();

	private static final QuickTipFacade qtfacade = new QuickTipFacade();

	private QuickTipFacade() {

		algo1 = QuickTipFactory.getInstance().quickTipAlgoSwitcher(1);
		algo2 = QuickTipFactory.getInstance().quickTipAlgoSwitcher(2);
		algo3 = QuickTipFactory.getInstance().quickTipAlgoSwitcher(3);
	}

	public List<GameTicket> callProperQuickTipGenerator(int gameticketParam, int algoParam) {
		
		List<GameTicket> gtl = IntStream.rangeClosed(1, gameticketParam==0?1:gameticketParam)
				.mapToObj(e-> new GameTicket())
				.peek(e-> algorithmCaller(e, algoParam))
				.collect(Collectors.toList());		
	
		return gtl;
	}

	private void algorithmCaller(GameTicket input, int algoParam) {
		
		xmlParse(algoParam);
		
		switch (algoParam) {
		case 1:
			algo1.QuickTipGeneratorOne(params.get(0), params.get(1));
		case 2:
			algo2.QuickTipGeneratorTwo(params.get(0), params.get(1));
		case 3:
			algo3.QuickTipGeneratorThree(params.get(0), params.get(1), params.get(2));
		default:
			throw new UnsupportedOperationException();
		}
		
		
	}

	private void xmlParse(int algoParam){
		
		File xmlFile = new File("resources/quickTipParam.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=null;
		Document doc=null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		getParamsByAlgoId(doc, algoParam);
	}
	

private void getParamsByAlgoId(Document doc, int algoParam) {

	NodeList algoNodes = doc.getElementsByTagName("algo");
	
	for(int i=0; i<algoNodes.getLength(); i++)
	{
		Node algoNode = algoNodes.item(i);
		if(algoNode.getNodeType() == Node.ELEMENT_NODE && ((Element) algoNode).getAttribute("id").equals(""+algoParam))
		{
			Element studentElement = (Element) algoNode;
			NodeList subNodes = ((Element) algoNode).getChildNodes();			
			for(int z=0; i<subNodes.getLength(); z++){
				params.add(Integer.parseInt(subNodes.item(z).getNodeValue()));				
			}
		}
	}
		
}


	
	
	
	public static QuickTipFacade getQtfacade() {
		return qtfacade;
	}

}
