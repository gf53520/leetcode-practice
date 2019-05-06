package others;

// 657 https://leetcode-cn.com/problems/robot-return-to-origin/
// 657. 机器人能否返回原点
// R（右），L（左），U（上）和 D（下）
/*
输入: "UD"
输出: true
解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，
因此它最终回到它开始的原点。因此，我们返回 true。
输入: "LL"
输出: false
解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，
因为它在移动结束时没有返回原点。
 */
public class JudgeCircle {

  public boolean judgeCircle(String moves) {
    int rightCut = 0;
    int downCut = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'R') {
        rightCut++;
      } else if (moves.charAt(i) == 'L') {
        rightCut--;
      } else if (moves.charAt(i) == 'D') {
        downCut++;
      } else {
        downCut--;
      }
    }
    return rightCut == 0 && downCut == 0;
  }
}
