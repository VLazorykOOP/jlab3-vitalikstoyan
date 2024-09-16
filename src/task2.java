// Абстрактний базовий клас Function
abstract class Function {
    // Абстрактний метод для обчислення значення функції в точці x
    public abstract double calculate(double x);

    // Абстрактний метод для виводу результату
    public abstract void printResult(double x);
}

// Похідний клас Ellipse (еліпс)
class Ellipse extends Function {
    private double a;  // Піввісь a
    private double b;  // Піввісь b

    // Конструктор
    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Реалізація методу для обчислення функції еліпсу
    @Override
    public double calculate(double x) {
        // Формула для еліпсу: (x^2 / a^2) + (y^2 / b^2) = 1, де y = sqrt((1 - x^2 / a^2) * b^2)
        if (Math.abs(x) > a) {
            throw new IllegalArgumentException("X must be within the range [-a, a]");
        }
        return Math.sqrt((1 - (x * x) / (a * a)) * (b * b));
    }

    // Реалізація методу для виводу результату
    @Override
    public void printResult(double x) {
        try {
            double y = calculate(x);
            System.out.println("For Ellipse with a = " + a + " and b = " + b + ", at x = " + x + ", y = " + y);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Перевантаження методу toString
    @Override
    public String toString() {
        return "Ellipse with a = " + a + " and b = " + b;
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ellipse ellipse = (Ellipse) obj;
        return Double.compare(ellipse.a, a) == 0 && Double.compare(ellipse.b, b) == 0;
    }
}

// Похідний клас Hyperbola (гіпербола)
class Hyperbola extends Function {
    private double a;  // Параметр a
    private double b;  // Параметр b

    // Конструктор
    public Hyperbola(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Реалізація методу для обчислення функції гіперболи
    @Override
    public double calculate(double x) {
        // Формула для гіперболи: (x^2 / a^2) - (y^2 / b^2) = 1, де y = sqrt((x^2 / a^2 - 1) * b^2)
        if (Math.abs(x) < a) {
            throw new IllegalArgumentException("X must be outside the range [-a, a]");
        }
        return Math.sqrt(((x * x) / (a * a) - 1) * (b * b));
    }

    // Реалізація методу для виводу результату
    @Override
    public void printResult(double x) {
        try {
            double y = calculate(x);
            System.out.println("For Hyperbola with a = " + a + " and b = " + b + ", at x = " + x + ", y = " + y);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Перевантаження методу toString
    @Override
    public String toString() {
        return "Hyperbola with a = " + a + " and b = " + b;
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hyperbola hyperbola = (Hyperbola) obj;
        return Double.compare(hyperbola.a, a) == 0 && Double.compare(hyperbola.b, b) == 0;
    }
}

// Основна програма
public class task2 {
    public static void main(String[] args) {
        // Масив об'єктів класів Ellipse і Hyperbola
        Function[] functions = new Function[2];

        // Створюємо об'єкти класів Ellipse і Hyperbola
        functions[0] = new Ellipse(5, 3);
        functions[1] = new Hyperbola(4, 2);

        // Демонструємо роботу методів calculate і printResult
        for (Function function : functions) {
            System.out.println(function);
            function.printResult(3);  // Викликаємо printResult для кожного об'єкта
        }

        // Перевірка перевантаженого методу equals
        Ellipse ellipse1 = new Ellipse(5, 3);
        Ellipse ellipse2 = new Ellipse(5, 3);
        Hyperbola hyperbola1 = new Hyperbola(4, 2);
        Hyperbola hyperbola2 = new Hyperbola(4, 3);

        System.out.println("ellipse1 equals ellipse2: " + ellipse1.equals(ellipse2));  // True
        System.out.println("hyperbola1 equals hyperbola2: " + hyperbola1.equals(hyperbola2));  // False
    }
}
