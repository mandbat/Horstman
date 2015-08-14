package kolyaHomeTask3;

import java.util.Arrays;

public class shift_massiv {

	private static boolean check_params(String[] params) {

		if (params.length != 4) {

			System.out.println("Usage:");
			System.out.println("	java shift_massiv <length_x>, <length_y>, <shift>, <direction>");
			System.out.println("		length_x  - ширина массива");
			System.out.println("		length_y  - высота массива");
			System.out.println("		shift     - смещение");
			System.out.println("		direction - направление сдвига: ");
			System.out.println("			U - вверх");
			System.out.println("			D - вниз");
			System.out.println("			L - влево");
			System.out.println("			R - вправо");
			return false;

		}

		boolean all_ok = true;
		try {
			Integer.parseInt(params[0]);
		} catch (Exception e) {
			all_ok = false;
			System.out.println("Неверно задан параметр \"length_x\"");
		}

		try {
			Integer.parseInt(params[1]);
		} catch (Exception e) {
			all_ok = false;
			System.out.println("Неверно задан параметр \"length_y\"");
		}

		try {
			Integer.parseInt(params[2]);
		} catch (Exception e) {
			all_ok = false;
			System.out.println("Неверно задан параметр \"shift\"");
		}

		try {
			String direction = params[2];
			if (direction.length() != 1 && direction.indexOf("UDLR") == -1) {
				all_ok = false;
				System.out.println("Неверно задан параметр \"direction\"");
			}
		} catch (Exception e) {
			all_ok = false;
			System.out.println("Неверно задан параметр \"direction\"");
		}

		return all_ok;
	}

	public static void main(String[] args) {

		if (!check_params(args))
			return;

		int length_x = Integer.parseInt(args[0]);
		int length_y = Integer.parseInt(args[1]);
		int shift = Integer.parseInt(args[2]);
		String direction = args[3];

		// Тестовые данные
		length_x = 5;
		length_y = 5;
		direction = "R";
		shift = 2;

		System.out.println("Параметры:");
		System.out.println(" ширина		: " + length_x);
		System.out.println(" высота		: " + length_y);
		System.out.println(" смещение	: " + shift);
		System.out.println(" направление	: " + direction);

		int[][] mass = new int[length_y][length_x];

		System.out.println("------ ");
		// оптимизация смещения
		int tmp_len = 0;
		String direction_back;
		if (direction == "U" || direction == "D") {
			tmp_len = length_y;
			direction_back = direction == "U" ? "D" : "U";
		} else {
			tmp_len = length_x;
			direction_back = direction == "L" ? "R" : "L";
		}

		while (shift > tmp_len)
			shift = shift - tmp_len;

		if (shift > (tmp_len / 2)) {
			shift = tmp_len - shift;
			direction = direction_back;
		}

		System.out.println("Оптимизированное смещение: " + shift);
		System.out.println("Оптимизированное направление: " + direction);

		System.out.println("------ ");
		System.out.println("Исходный массив:");

		// генерацмя массива
		for (int iy = 0; iy <= length_y - 1; iy++) {
			for (int ix = 0; ix <= length_x - 1; ix++) {
				mass[iy][ix] = (int) (Math.random() * 10);
				System.out.print(mass[iy][ix] + " ");
			}
			System.out.println();
		}

		if (shift == 0) {
			return;
		}
		// сдвиг вправо
		if (direction == "R") {
			for (int y = 0; y <= length_y - 1; y++) {
				int[] mass_tmp = new int[shift];
				for (int x = length_x - 1; x >= 0; x--) {
					if (x > length_x - 1 - shift) {
						mass_tmp[(shift - 1) - (length_x - 1 - x)] = mass[y][x];
						// System.out.println(Arrays.toString(mass_tmp));
					} else {
						mass[y][x + shift] = mass[y][x];
					}
				}
				for (int i = 0; i <= shift - 1; i++) {
					mass[y][i] = mass_tmp[i];
				}
			}
			// сдвиг влево
		} else if (direction == "L") {

			for (int y = 0; y <= length_y - 1; y++) {
				int[] mass_tmp = new int[shift];
				for (int x = 0; x <= length_x - 1; x++) {
					if (x <= shift - 1) {
						mass_tmp[x] = mass[y][x];
						System.out.println(Arrays.toString(mass_tmp));
					} else {
						mass[y][x - shift] = mass[y][x];
					}
				}
				for (int i = 0; i <= shift - 1; i++) {
					mass[y][(length_x - 1) - (shift - 1) + i] = mass_tmp[i];
				}
			}

		} else if (direction == "D") {

		} else if (direction == "U") {

		}

		// Вывод смещенного массива
		System.out.println("------ ");
		System.out.println("Смещенный массив:");
		for (int iy = 0; iy <= length_y - 1; iy++) {
			for (int ix = 0; ix <= length_x - 1; ix++) {
				System.out.print(mass[iy][ix] + " ");
			}
			System.out.println();
		}
	}
}
