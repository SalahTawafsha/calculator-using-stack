package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private static CursorStack<String> stack = new CursorStack<>(50);

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Calculator");
		primaryStage.getIcons().add(new Image("icon.png"));
		primaryStage.setResizable(false);

		TextField expression = new TextField();
		expression.setEditable(false);
		expression.setMinHeight(50);
		expression.setMaxWidth(300);

		TextField postfix = new TextField();
		postfix.setEditable(false);
		postfix.setMinHeight(50);
		postfix.setMaxWidth(300);

		TextField result = new TextField();
		result.setEditable(false);
		result.setMinHeight(30);
		result.setMaxWidth(300);

		VBox up = new VBox(0, expression, postfix, result);
		up.setAlignment(Pos.CENTER);

		GridPane pane = new GridPane();
		pane.setVgap(3);
		pane.setHgap(3);

		Button sin = new Button("sin");
		sin.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		sin.setOnAction(e -> expression.setText(expression.getText() + "sin ( "));

		Button cos = new Button("cos");
		cos.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		cos.setOnAction(e -> expression.setText(expression.getText() + "cos ( "));

		Button tan = new Button("tan");
		tan.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		tan.setOnAction(e -> expression.setText(expression.getText() + "tan ( "));

		Button openDelimiter = new Button("(");
		openDelimiter.setStyle("-fx-color:white;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		openDelimiter.setOnAction(e -> expression.setText(expression.getText() + "( "));

		Button closeDelimiter = new Button(")");
		closeDelimiter.setStyle("-fx-color:white;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		closeDelimiter.setOnAction(e -> expression.setText(expression.getText() + " )"));

		Button fact = new Button("!");
		fact.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		fact.setOnAction(e -> expression.setText(expression.getText() + " ! "));

		Button off = new Button("off");
		off.setStyle("-fx-color:INDIANRED;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");

		off.setOnAction(e -> primaryStage.close());

		pane.addRow(0, sin, cos, tan, openDelimiter, closeDelimiter, fact, off);

		ImageView piIcon = new ImageView("pi.png");
		piIcon.setFitWidth(20);
		piIcon.setFitHeight(20);
		Button piButton = new Button("", piIcon);
		piButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		piButton.setOnAction(e -> expression.setText(expression.getText() + "3.141592653589793"));

		ImageView powIcon = new ImageView("pow.png");
		powIcon.setFitWidth(20);
		powIcon.setFitHeight(20);
		Button powButton = new Button("", powIcon);
		powButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		powButton.setOnAction(e -> expression.setText(expression.getText() + " ^ "));

		Button seven = new Button("7");
		seven.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		seven.setOnAction(e -> expression.setText(expression.getText() + "7"));

		Button eight = new Button("8");
		eight.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		eight.setOnAction(e -> expression.setText(expression.getText() + "8"));

		Button nine = new Button("9");
		nine.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		nine.setOnAction(e -> expression.setText(expression.getText() + "9"));

		ImageView divide = new ImageView("divide.png");
		divide.setFitWidth(20);
		divide.setFitHeight(20);
		Button divideButton = new Button("", divide);
		divideButton.setStyle("-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		divideButton.setOnAction(e -> expression.setText(expression.getText() + " / "));

		Button minusSign = new Button("(-)");
		minusSign.setStyle("-fx-color:white;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		minusSign.setOnAction(e -> {
			if (expression.getText().length() > 0
					&& expression.getText().charAt(expression.getText().length() - 1) == '-')
				expression.setText(expression.getText().substring(0, expression.getText().length() - 1));
			else
				expression.setText(expression.getText() + "-");

		});

		pane.addRow(1, piButton, powButton, seven, eight, nine, divideButton, minusSign);

		ImageView xToPow2Icon = new ImageView("xSqr.png");
		xToPow2Icon.setFitWidth(20);
		xToPow2Icon.setFitHeight(20);
		Button xPowButton = new Button("", xToPow2Icon);
		xPowButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		xPowButton.setOnAction(e -> expression.setText(expression.getText() + " ^ 2"));

		ImageView sqrtView = new ImageView("sqrt.png");
		sqrtView.setFitWidth(20);
		sqrtView.setFitHeight(20);
		Button sqrtButton = new Button("", sqrtView);
		sqrtButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		sqrtButton.setOnAction(e -> expression.setText(expression.getText() + "sqrt ( "));

		Button four = new Button("4");
		four.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		four.setOnAction(e -> expression.setText(expression.getText() + "4"));

		Button five = new Button("5");
		five.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		five.setOnAction(e -> expression.setText(expression.getText() + "5"));

		Button six = new Button("6");
		six.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		six.setOnAction(e -> expression.setText(expression.getText() + "6"));

		Button multiply = new Button("X");
		multiply.setStyle("-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		multiply.setOnAction(e -> expression.setText(expression.getText() + " * "));

		Button ca = new Button("CA");
		ca.setStyle("-fx-color:INDIANRED;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		ca.setOnAction(e -> {
			stack.clear();
			expression.setText("");
			postfix.setText("");
			result.setText("");
		});

		pane.addRow(2, xPowButton, sqrtButton, four, five, six, multiply, ca);

		ImageView expIcon = new ImageView("exp.png");
		expIcon.setFitWidth(20);
		expIcon.setFitHeight(20);
		Button expButton = new Button("", expIcon);
		expButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		expButton.setOnAction(e -> expression.setText(expression.getText() + "exp ( "));

		Button lnButton = new Button("ln");
		lnButton.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		lnButton.setOnAction(e -> expression.setText(expression.getText() + "ln ( "));

		Button one = new Button("1");
		one.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		one.setOnAction(e -> expression.setText(expression.getText() + "1"));

		Button two = new Button("2");
		two.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		two.setOnAction(e -> expression.setText(expression.getText() + "2"));

		Button three = new Button("3");
		three.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		three.setOnAction(e -> expression.setText(expression.getText() + "3"));

		Button minus = new Button("-");
		minus.setStyle("-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		minus.setOnAction(e -> expression.setText(expression.getText() + " - "));

		Button radDeg = new Button("Deg");
		radDeg.setStyle("-fx-color:INDIANRED;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		radDeg.setOnAction(e -> {
			if (radDeg.getText().equals("Deg"))
				radDeg.setText("Rad");
			else
				radDeg.setText("Deg");
		});

		pane.addRow(3, expButton, lnButton, one, two, three, minus, radDeg);

		Button log = new Button("LOG");
		log.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		log.setOnAction(e -> expression.setText(expression.getText() + "log ( "));

		ImageView oneDivideByXView = new ImageView("1onx.png");
		oneDivideByXView.setFitWidth(20);
		oneDivideByXView.setFitHeight(20);
		Button oneDivideByX = new Button("", oneDivideByXView);
		oneDivideByX.setStyle("-fx-color:skyblue;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		oneDivideByX.setOnAction(e -> expression.setText(expression.getText() + "1 / "));

		Button add = new Button("+");
		add.setStyle("-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		add.setOnAction(e -> expression.setText(expression.getText() + " + "));

		Button mod = new Button("%");
		mod.setStyle(
				"-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10;-fx-background-radius:10");
		mod.setOnAction(e -> expression.setText(expression.getText() + " % "));

		Button point = new Button(".");
		point.setStyle("-fx-color:darkgray;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		point.setOnAction(e -> expression.setText(expression.getText() + "."));

		ImageView back = new ImageView("back.png");
		back.setFitWidth(20);
		back.setFitHeight(20);
		Button backButton = new Button("", back);
		backButton.setStyle("-fx-color:INDIANRED;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		backButton.setOnAction(e -> {
			String exp = expression.getText();

			if (exp.length() > 1 && Character.isDigit(exp.charAt(exp.length() - 1))
					|| exp.charAt(exp.length() - 1) == '.')
				exp = exp.substring(0, exp.length() - 1);
			else if (exp.length() > 3 && exp.charAt(exp.length() - 2) == '(')
				exp = exp.substring(0, exp.length() - 2);
			else
				exp = exp.substring(0, lastSpace(exp));
			expression.setText(exp);
		});

		Button zero = new Button("0");
		zero.setStyle("-fx-color:black;-fx-min-width:40;-fx-min-height:48;-fx-background-radius:10");
		zero.setOnAction(e -> expression.setText(expression.getText() + "0"));

		pane.addRow(4, log, oneDivideByX, zero, point, mod, add, backButton);
		pane.setPadding(new Insets(5, 5, 0, 5));

		Button equal = new Button("=");
		equal.setStyle("-fx-color:skyblue;-fx-min-width:300;-fx-min-height:42;-fx-background-radius:10");

		equal.setOnAction(e -> {
			if (checkBraces(expression.getText())) {
				try {
					stack.clear();
					postfix.setText(toPostfix(expression.getText()));
					result.setText(evaluate(postfix.getText(), radDeg.getText()) + "");
				} catch (ArithmeticException e1) {
					postfix.setText("");
					result.setText(e1.getMessage());
				} catch (Exception e2) {
					stack.clear();
					postfix.setText("");
					result.setText("Invalid Expression");
				}
			} else {
				stack.clear();
				postfix.setText("");
				result.setText("Error in Braces");
			}

		});

		VBox all = new VBox(5, up, pane, equal);
		all.setPadding(new Insets(30, 20, 30, 20));

		all.setAlignment(Pos.CENTER);
		all.setBackground(new Background(new BackgroundImage(new Image("backg.png"), null, null, null, null)));

		Scene s = new Scene(all);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	private int lastSpace(String exp) {
		for (int i = exp.length() - 2; i >= 0; i--)
			if (exp.charAt(i) == ' ')
				return i + 1;

		return 0;
	}

	private boolean checkBraces(String text) {
		String ch;

		if (text.equals(""))
			return true;

		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == '(')
				stack.push("(");
			else if (text.charAt(i) == ')') {
				ch = stack.pop();
				if (ch == null || !ch.equals("("))
					return false;
			}

		if (!stack.isEmpty()) {
			stack.clear();
			return false;
		} else {
			return true;
		}

	}

	private String toPostfix(String s) {
		String[] tokens = s.split(" ");
		String ret = "";
		for (int i = 0; i < tokens.length; i++)
			switch (tokens[i]) {
			case "+":
			case "-":
				while (!stack.isEmpty() && !stack.peek().equals("("))
					ret += " " + stack.pop();

				stack.push(tokens[i]);
				break;
			case "/":
			case "*":
			case "%":
				while (!stack.isEmpty() && !hasPrecedence(tokens[i], stack.peek()) && !stack.peek().equals("("))
					ret += " " + stack.pop();

				stack.push(tokens[i]);
				break;
			case "^":
			case "(":
			case "tan":
			case "cos":
			case "sin":
			case "sqrt":
			case "exp":
			case "ln":
			case "log":
			case "-tan":
			case "-cos":
			case "-sin":
			case "-sqrt":
			case "-exp":
			case "-ln":
			case "-log":
				stack.push(tokens[i]);
				break;
			case ")":
				while (!stack.isEmpty() && !stack.peek().equals("("))
					ret += " " + stack.pop();
				stack.pop();
				break;
			case "":
				break;
			default:
				ret += " " + tokens[i];

			}
		while (!stack.isEmpty())
			ret += " " + stack.pop();

		return ret;
	}

	private boolean hasPrecedence(String op1, String op2) {
		if (op1.equals("+") || op1.equals("-"))
			return false;
		else if (op2.equals("+") || op2.equals("-"))
			return true;
		return false;
	}

	private double evaluate(String text, String radDeg) throws ArithmeticException {
		String[] tokens = text.split(" ");
		double res, x, y;
		for (int i = 0; i < tokens.length; i++) {
			boolean bobo = false;
			if (tokens[i].length() > 2 && tokens[i].charAt(0) == '-' && !Character.isDigit(tokens[i].charAt(1))) {
				tokens[i] = tokens[i].substring(1);
				bobo = true;
			}
			switch (tokens[i]) {
			case "+":
				res = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
				stack.push(String.format("%.9f", res));
				break;
			case "-":
				res = -Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
				stack.push(String.format("%.9f", res));
				break;
			case "/":
				y = Double.parseDouble(stack.pop());
				x = Double.parseDouble(stack.pop());
				if (y != 0)
					res = x / y;
				else
					throw new ArithmeticException("Cannot divide by zero");
				stack.push(String.format("%.9f", res));
				break;
			case "*":
				res = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
				stack.push(String.format("%.9f", res));
				break;
			case "%":
				y = Double.parseDouble(stack.pop());
				x = Double.parseDouble(stack.pop());
				res = x % y;
				stack.push(String.format("%.9f", res));
				break;
			case "^":
				y = Double.parseDouble(stack.pop());
				x = Double.parseDouble(stack.pop());
				res = Math.pow(x, y);
				stack.push(String.format("%.9f", res));
				break;
			case "!":
				if (Integer.parseInt(stack.peek()) < 0)
					throw new ArithmeticException("Invalid Expression");
				res = factorial(Integer.parseInt(stack.pop()));
				stack.push(String.format("%.9f", res));
				break;
			case "tan":
				if (radDeg.equals("Deg"))
					res = Math.tan(Math.toRadians(Double.parseDouble(stack.pop())));
				else
					res = Math.tan(Double.parseDouble(stack.pop()));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "cos":
				if (radDeg.equals("Deg"))
					res = Math.cos(Math.toRadians(Double.parseDouble(stack.pop())));
				else
					res = Math.cos(Double.parseDouble(stack.pop()));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "sin":
				if (radDeg.equals("Deg"))
					res = Math.sin(Math.toRadians(Double.parseDouble(stack.pop())));
				else
					res = Math.sin(Double.parseDouble(stack.pop()));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "sqrt":
				res = Math.sqrt((Double.parseDouble(stack.pop())));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "exp":
				res = Math.exp((Double.parseDouble(stack.pop())));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "ln":
				res = Math.log((Double.parseDouble(stack.pop())));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "log":
				res = Math.log10((Double.parseDouble(stack.pop())));
				if (bobo)
					res *= -1;
				stack.push(String.format("%.9f", res));
				break;
			case "":
				break;
			default:
				stack.push(tokens[i]);

			}
		}
		return Double.parseDouble(stack.pop());

	}

	private long factorial(int n) {
		if (n <= 2) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		launch();
	}
}