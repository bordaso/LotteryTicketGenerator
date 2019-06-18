package main;

import java.util.List;

public class GamePanel {
	
	private List<Integer> numbers;

	public GamePanel(List<Integer> numbers) {
		super();
		this.numbers = numbers;
	}
	
	public GamePanel() {
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
}
