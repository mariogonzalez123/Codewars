-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-11-2022 a las 12:04:12
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `codefight`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicios`
--

DROP TABLE IF EXISTS `ejercicios`;
CREATE TABLE IF NOT EXISTS `ejercicios` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(30) NOT NULL,
  `DESCRIPCION` text NOT NULL,
  `TEST_VISIBLES` text NOT NULL,
  `SOLUCION` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejercicios`
--

INSERT INTO `ejercicios` (`ID`, `TITULO`, `DESCRIPCION`, `TEST_VISIBLES`, `SOLUCION`) VALUES
(16, 'Function 2 - squaring an argum', 'Now you have to write a function that takes an argument and returns the square of it.\n', 'import org.junit.jupiter.api.Test;\r\nimport static org.junit.jupiter.api.Assertions.assertEquals;\r\n// TODO: Replace examples and use TDD by writing your own tests\r\npublic class SolutionTest {\r\n    @Test\r\n    void fixed_tests() {\r\n      assertEquals(4, Kata.square(2));\r\n      assertEquals(2500, Kata.square(50));\r\n      assertEquals(1, Kata.square(1));\r\n    }\r\n}\r\n', 'public class Kata\r\n {\r\n  public static int square(int n){\r\n    return 3;\r\n       //Your Code\r\n  }\r\n }\r\n'),
(17, 'Testing 1-2-3', 'Your team is writing a fancy new text editor and you\'ve been tasked with implementing the line numbering.\r\nWrite a function which takes a list of strings and returns each line prepended by the correct number.\r\nThe numbering starts at 1. The format is n: string. Notice the colon and space in between.\r\n', 'import java.util.Arrays;\r\n\r\nimport org.junit.jupiter.api.Test;\r\nimport static org.junit.jupiter.api.Assertions.assertIterableEquals;\r\n\r\npublic class LineNumberingTest {\r\n    @Test\r\n    public void basicTests() {\r\n        assertIterableEquals(Arrays.asList(), LineNumbering.number(Arrays.asList()));\r\n        assertIterableEquals(Arrays.asList(\\\"1: a\\\", \\\"2: b\\\", \\\"3: c\\\"), LineNumbering.number(Arrays.asList(\\\"a\\\", \\\"b\\\", \\\"c\\\")));\r\n        assertIterableEquals(Arrays.asList(\\\"1: \\\", \\\"2: \\\", \\\"3: \\\", \\\"4: \\\", \\\"5: \\\"), LineNumbering.number(Arrays.asList(\\\"\\\", \\\"\\\", \\\"\\\", \\\"\\\", \\\"\\\")));\r\n    }\r\n}\r\n', 'import java.util.*;\r\nimport java.util.Arrays;\r\nimport java.util.List;\r\npublic class LineNumbering {\r\n    public static List<String> number(List<String> lines) {\r\n        return Arrays.asList(\\\"a\\\",\\\"b\\\");\r\n    }\r\n}\r\n'),
(18, 'List Filtering', 'In this kata you will create a function that takes a list of non-negative integers and strings and returns a new list with the strings filtered out.', 'import java.util.List;\\r\\nimport org.junit.jupiter.api.Test;\\r\\nimport static org.junit.jupiter.api.Assertions.assertEquals;\\r\\npublic class ExampleTests {\\r\\n  @Test\\r\\n  public void examples() {\\r\\n    assertEquals(List.of(1, 2), Kata.filterList(List.of(1, 2, \\\"a\\\", \\\"b\\\"))); \\r\\n    assertEquals(List.of(1, 0, 15), Kata.filterList(List.of(1, \\\"a\\\", \\\"b\\\", 0, 15))); \\r\\n    assertEquals(List.of(1, 2, 123), Kata.filterList(List.of(1, 2, \\\"aasf\\\", \\\"1\\\", \\\"123\\\", 123))); \\r\\n  } \\r\\n}\\r\\n', 'import java.util.List;\r\n\r\npublic class Kata {\r\n  \r\n  public static List<Object> filterList(final List<Object> list) {\r\n    // Return the List with the Strings filtered out\r\n    return null;\r\n  }\r\n}\r\n'),
(19, 'Sum The Strings', 'Create a function that takes 2 integers in form of a string as an input, and outputs the sum (also as a string):', 'import org.junit.jupiter.api.Test;\r\nimport static org.junit.jupiter.api.Assertions.assertEquals;\r\n\r\n// TODO: Replace examples and use TDD by writing your own tests\r\n\r\npublic class SolutionTest {\r\n    @Test\r\n    void basicTest() {\r\n      assertEquals(\\\"9\\\",Kata.sumStr(\\\"4\\\",\\\"5\\\"));\r\n      assertEquals(\\\"39\\\",Kata.sumStr(\\\"34\\\",\\\"5\\\"));\r\n      assertEquals(\\\"8\\\",Kata.sumStr(\\\"\\\",\\\"8\\\"));\r\n      assertEquals(\\\"9\\\",Kata.sumStr(\\\"9\\\",\\\"\\\"));\r\n      assertEquals(\\\"0\\\",Kata.sumStr(\\\"\\\",\\\"\\\"));\r\n    }\r\n}', 'public class Kata\r\n {\r\n  public static String sumStr(String a,String b)\r\n  { \r\n   //Your Code\r\n  }\r\n }');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicidad`
--

DROP TABLE IF EXISTS `publicidad`;
CREATE TABLE IF NOT EXISTS `publicidad` (
  `titulo` text NOT NULL,
  `contacto` text NOT NULL,
  `anunciante` text NOT NULL,
  `descripcion` text NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contador` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `publicidad`
--

INSERT INTO `publicidad` (`titulo`, `contacto`, `anunciante`, `descripcion`, `id`, `contador`) VALUES
('Métrica Consulting', 'https://www.metrica.es/', 'Métrica S.L.', 'Apostamos por las tecnologías más innovadoras. Tenemos una amplia experiencia integrando tecnologías y cooperando con los fabricantes de tecnología líderes en el mercado, lo que nos permite ofrecer a nuestros clientes Soluciones Certificadas innovadoras y fiables.', 1, 94),
('Carnícas Pepe', '87654321', 'Cárnicas Pepe', 'En cárnicas Pepe nos esforzamos por que la carne que llega a tu casa sea fresca y de calidad.', 2, 58),
('Mario', 'Password', 'Paco', ' hola,hdp', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tests`
--

DROP TABLE IF EXISTS `tests`;
CREATE TABLE IF NOT EXISTS `tests` (
  `test_ocultos` text NOT NULL,
  `id_ejercicio` int(11) NOT NULL,
  PRIMARY KEY (`id_ejercicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tests`
--

INSERT INTO `tests` (`test_ocultos`, `id_ejercicio`) VALUES
('import org.junit.jupiter.api.Test;\r\nimport static org.junit.jupiter.api.Assertions.assertEquals;\r\nimport org.junit.jupiter.api.RepeatedTest;\r\n// TODO: Replace examples and use TDD by writing your own tests\r\npublic class SolutionTest {\r\n    @Test\r\n    void fixed_tests() {\r\n      assertEquals(4, Kata.square(2));\r\n      assertEquals(2500, Kata.square(50));\r\n      assertEquals(1, Kata.square(1));\r\n    }\r\n  \r\n  @RepeatedTest(5)\r\n    void random_tests() {\r\n      int num= (int) (Math.random()*101);\r\n      int res=num*num;\r\n      assertEquals(res, Kata.square(num));\r\n    }\r\n}\r\n', 16),
('import java.util.*;\r\nimport java.util.stream.*;\r\nimport org.junit.jupiter.api.Test;\r\nimport static org.junit.jupiter.api.Assertions.assertIterableEquals;\r\npublic class LineNumberingTest {\r\n    @Test\r\n    public void basicTests() {\r\n        assertIterableEquals(Arrays.asList(), LineNumbering.number(Arrays.asList()));\r\n        assertIterableEquals(Arrays.asList(\"1: a\", \"2: b\", \"3: c\"), LineNumbering.number(Arrays.asList(\"a\", \"b\", \"c\")));\r\n        assertIterableEquals(Arrays.asList(\"1: \", \"2: \", \"3: \", \"4: \", \"5: \"), LineNumbering.number(Arrays.asList(\"\", \"\", \"\", \"\", \"\")));\r\n    }\r\n    \r\n    private List<String> sol(List<String> lines) {\r\n        return IntStream.range(0, lines.size()).mapToObj(i -> (i + 1) + \": \" + lines.get(i)).collect(Collectors.toList());\r\n    }\r\n    @Test\r\n    public void randomTests() {\r\n        Random r = new Random();\r\n        for (int i = 0; i < 100; i++) {\r\n            List<String> l = IntStream.range(0, r.nextInt(20)).mapToObj(k -> {\r\n                StringBuilder s = new StringBuilder();\r\n                for (int j = 0, len = r.nextInt(10); j < len; j++)\r\n                    s.append(\"abcdefghijklmnopqrstuvwxyz\".charAt(r.nextInt(26)));\r\n                return s.toString();\r\n            }).collect(Collectors.toList());\r\n            assertIterableEquals(sol(l), LineNumbering.number(l));\r\n        }\r\n    }\r\n}\r\n', 17),
('import org.junit.jupiter.api.Test;\r\nimport java.util.List;\r\nimport java.util.ArrayList;\r\nimport java.util.concurrent.ThreadLocalRandom;\r\nimport java.util.stream.Collectors;\r\nimport static org.junit.jupiter.api.Assertions.assertEquals;\r\npublic class SolutionTests {\r\n\r\n  @Test\r\n  void examples() {\r\n    assertEquals(List.of(1,2), Kata.filterList(List.of(1,2,\"a\",\"b\")));\r\n    assertEquals(List.of(1,0,15), Kata.filterList(List.of(1,\"a\",\"b\",0,15)));\r\n    assertEquals(List.of(1,2,123), Kata.filterList(List.of(1,2,\"aasf\",\"1\",\"123\",123)));\r\n  }\r\n  @Test\r\n  void extras() {\r\n    assertEquals(List.of(), Kata.filterList(List.of(\"a\",\"b\",\"1\")));\r\n    assertEquals(List.of(1,2), Kata.filterList(List.of(1,2,\"a\",\"b\")));\r\n  }\r\n  @Test\r\n  void randomTest(){\r\n    ThreadLocalRandom rand = ThreadLocalRandom.current();\r\n    for(int i = 0; i < 20; i++) {\r\n      int size = rand.nextInt(20);\r\n      List<Object> input = new ArrayList<>();\r\n      List<Integer> expected = new ArrayList<>();\r\n      for(int j = 0; j < size; ++j) {\r\n        if(rand.nextBoolean()) {\r\n          int n = rand.nextInt(0, 1000);\r\n          input.add(n);\r\n          expected.add(n);\r\n        } else {\r\n          if(rand.nextBoolean())\r\n            input.add(rand.ints(rand.nextInt(6), 48, 123).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());\r\n          else input.add(Integer.toString(rand.nextInt(1000)));\r\n        }\r\n      }\r\n      \r\n      List<Object> result = Kata.filterList(List.copyOf(input));\r\n      assertEquals(expected, result);\r\n    }\r\n  }\r\n  \r\n}', 18),
('import org.junit.jupiter.api.Test;\r\nimport org.junit.jupiter.api.RepeatedTest;\r\nimport static org.junit.jupiter.api.Assertions.assertEquals;\r\n\r\npublic class SolutionTest {\r\n    @Test\r\n    void basicTest() {\r\n      assertEquals(\"9\",Kata.sumStr(\"4\",\"5\"));\r\n      assertEquals(\"39\",Kata.sumStr(\"34\",\"5\"));\r\n      assertEquals(\"8\",Kata.sumStr(\"\",\"8\"));\r\n      assertEquals(\"9\",Kata.sumStr(\"9\",\"\"));\r\n      assertEquals(\"0\",Kata.sumStr(\"\",\"\"));\r\n    }\r\n  \r\n\r\n    @RepeatedTest(5)\r\n    void random_tests() {\r\n      int num1= (int) (Math.random()*101);\r\n      int num2= (int) (Math.random()*101);\r\n      String a = num1+\"\";\r\n      String b = num2+\"\";\r\n      \r\n      int res=Integer.parseInt(a)+Integer.parseInt(b);\r\n      String exp = String.valueOf(res);\r\n      assertEquals(exp,Kata.sumStr(a,b));\r\n    }\r\n}', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `nombre` text NOT NULL,
  `password` text NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `password`, `id`, `role`) VALUES
('Daniel', '$2a$10$XyU6Bxl.x17PWrTOeswuh.199zEPiT7hHgyaRgAG8TFP6HCijIXRW', 1, 'ADMIN'),
('Emilio', '$2a$10$KC2LlNujuWUTS7QL25AvoO0zpVHA0b9C/HoY2W3lX6kxxwF4AiGUW', 2, 'ADMIN'),
('Eva', '$2a$10$paRODAQmtI9j3TUCZse/jeAwS/lJZjezulAAavz8vlk6gEJC/OuF2', 3, 'ADMIN'),
('Mario', '$2a$10$ViDQ7TBN2AetxOI9.dV/vO9uZtEHnLV55ZJSOFu.KgkD03BBshyJK', 4, 'ADMIN'),
('Paco', '$2a$10$90W33oAU7tgUkaDyhmMqU.YyAXZAfQEKtIreALj9ZKrsEeNQBVh1G', 5, 'USER'),
('Yeray', '$2a$10$MufP2VZREVC7qQhtgHJw8.GQiX3.Xx6bay.Ap5VRDAU1Xl02Nun4y', 6, 'USER');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
