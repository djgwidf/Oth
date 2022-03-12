package Othello;

public class Board {

  static boolean game = true;

  static String[][] board = new String[8][8];

  static final String EMPTY = "　";
  static final String BLACK = "●";
  static final String WHITE = "○";

  static String stone;
  static String rev_stone;

  static public void initialize() {

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = EMPTY;
      }
    }

    board[3][3] = BLACK;
    board[3][4] = WHITE;
    board[4][3] = WHITE;
    board[4][4] = BLACK;

    stone = BLACK;
    rev_stone = WHITE;

    game = true;

  }

  static public void showBoard() {

    boolean existempty = false;
    int cnt_black = 0;
    int cnt_white = 0;

    int i = 0;
    System.out.println(" |0 |1 |2 |3 |4 |5 |6 |7 |");
    System.out.println("――――――――――――――");
    for (String[] sar : board) {

      System.out.print(i + " |");
      for (String s : sar) {

        System.out.print(s);
        System.out.print("|");

        if (s.equals(EMPTY)) {
          existempty = true;
        } else if (s.equals(BLACK)) {
          cnt_black++;
        } else if (s.equals(WHITE)) {
          cnt_white++;
        }

      }
      System.out.println();
      System.out.println("――――――――――――――");

      i++;

    }

    System.out.println(BLACK + ":" + cnt_black);
    System.out.println(WHITE + ":" + cnt_white);
    System.out.println("――――――――――――――");

    if (existempty) {

      System.out.println(stone + "のターンです");
    } else {
      System.out.println(stone + "ゲーム終了！");
      game = false;
    }
  }

  static public void setStone(int x, int y) {

    if (x > 7 || y > 7) {
      System.out.println("その位置に駒はおけません");
    }

    if (board[y][x].equals(EMPTY)) {
      board[y][x] = stone;

      turnStone(x, y);

      String next_rev_stone = stone;
      stone = rev_stone;
      rev_stone = next_rev_stone;

      showBoard();

    } else {
      System.out.println("その位置に駒はおけません");
    }
  }

  static public void turnStone(int x, int y) {

    turnLeftUp(x, y);
    turnUp(x, y);
    turnRightUp(x, y);
    turnLeft(x, y);
    turnRight(x, y);
    turnLeftDown(x, y);
    turnDown(x, y);
    turnRightDown(x, y);

  }

  static public void turnLeftUp(int x, int y) {
    if (y > 1 && x > 1) {
      String next = board[y - 1][x - 1];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x - i < 0 || y - i < 0 || board[y - i][x - i].equals(EMPTY)) {
            break;
          } else if (board[y - i][x - i].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y - t][x - t] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnUp(int x, int y) {
    if (y > 1) {
      String next = board[y - 1][x];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (y - i < 0 || board[y - i][x].equals(EMPTY)) {
            break;
          } else if (board[y - i][x].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y - t][x] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnRightUp(int x, int y) {
    if (y > 1 && x < 6) {
      String next = board[y - 1][x + 1];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x + i > 7 || y - i < 0 || board[y - i][x + i].equals(EMPTY)) { 
            break;
          } else if (board[y - i][x + i].equals(stone)) {
             for (int t = 1; t < i; t++) {
              board[y - t][x + t] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnDown(int x, int y) {
    if (y < 6) {
      String next = board[y + 1][x];
      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (y + i > 7 || board[y + i][x].equals(EMPTY)) { 
            break;
          } else if (board[y + i][x].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y + t][x] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnRight(int x, int y) {
    if (x < 6) {

      String next = board[y][x + 1];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x + i > 7 || board[y][x + i].equals(EMPTY)) {
            break;
          } else if (board[y][x + i].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y][x + t] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnLeftDown(int x, int y) {
    if (y < 6 && x > 1) {

      String next = board[y + 1][x - 1];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x - i < 0 || y + i > 7 || board[y + i][x - i].equals(EMPTY)) {
            break;
          } else if (board[y + i][x - i].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y + t][x - t] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnLeft(int x, int y) {
    if (x > 1) {
      String next = board[y][x - 1];

      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x - i < 0 || board[y][x - i].equals(EMPTY)) {
            break;
          } else if (board[y][x - i].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y][x - t] = stone;
            }
            break;
          }
        }
      }
    }
  }

  static public void turnRightDown(int x, int y) {
    if (y < 6 && x < 6) {
      String next = board[y + 1][x + 1];
      if (next.equals(rev_stone)) {
        for (int i = 2; true; i++) {
          if (x + i > 7 || y + i > 7 || board[y + i][x + i].equals(EMPTY)) {
            break;
          } else if (board[y + i][x + i].equals(stone)) {
            for (int t = 1; t < i; t++) {
              board[y + t][x + t] = stone;
            }
            break;
          }
        }
      }
    }
  }
}