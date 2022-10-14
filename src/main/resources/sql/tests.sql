# 0 - JAVA 1 - PYTHON 2 - CPP
#------------task_1#------------String aaaa\n \naaaa\nc\nbbb
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(shortestWord( new String[]{„aaaa”, „bbbb”, „cccccccc”}));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(shortestWord( new String[]{„aaaa”, „bbbbb”, „”}));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(shortestWord( new String[]{„aaaa”, „bbbb”, „cccc”}));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(shortestWord( new String[]{„aaaa”, „bbbb”, „c”}));', 0, 1);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(shortestWord( new String[]{„aaaa”, „bbb”, „cccccccc”}));', 0, 1);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(shortestWord([„aaaa”, „bbbb”, „cccccccc”]))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('println(shortestWord([„aaaa”, „bbbbb”, „”]))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('println(shortestWord([„aaaa”, „bbbb”, „cccc”]))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('println(shortestWord([„aaaa”, „bbbb”, „c”]))', 1, 1);
INSERT INTO test(content, language, task_id) VALUES ('println(shortestWord([„aaaa”, „bbb”, „cccccccc”]))', 1, 1);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << shortestWord({„aaaa”, „bbbb”, „cccccccc”}) << endl;', 2, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << shortestWord({„aaaa”, „bbbbb”, „”}) << endl;', 2, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << shortestWord({„aaaa”, „bbbb”, „cccc”}) << endl;', 2, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << shortestWord({„aaaa”, „bbbb”, „c”}) << endl;', 2, 1);
INSERT INTO test(content, language, task_id) VALUES ('cout << shortestWord({„aaaa”, „bbb”, „cccccccc”}) << endl;', 2, 1);
#------------task_2#------------int 76\n47\n-3
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(biggestNumber(new int[]{12, 12, 76}));', 0, 2);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(biggestNumber(new int[]{12, 47, -3}));', 0, 2);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(biggestNumber(new int[]{-3, -10, -21}));', 0, 2);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(biggestNumber([12, 12, 76]))', 1, 2);
INSERT INTO test(content, language, task_id) VALUES ('println(biggestNumber([12, 47, -3]))', 1, 2);
INSERT INTO test(content, language, task_id) VALUES ('println(biggestNumber([-3, -10, -21]))', 1, 2);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << biggestNumber({12, 12, 76}) << endl;', 2, 2);
INSERT INTO test(content, language, task_id) VALUES ('cout << biggestNumber({12, 47, -3}) << endl;', 2, 2);
INSERT INTO test(content, language, task_id) VALUES ('cout << biggestNumber({-3, -10, -21}) << endl;', 2, 2);
#------------task_3#------------int[] 2\n\n1,4\n1,2
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(findDuplicates(new int[]{1,2}, new int[]{2,3}));', 0, 3);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(findDuplicates(new int[]{1,2}, new int[]{3,4}));', 0, 3);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(findDuplicates(new int[]{1,2,3,4,5,6}, new int[]{1,4,15,21,0}));', 0, 3);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(findDuplicates(new int[]{1,2}, new int[]{1,2}));', 0, 3);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(findDuplicates([1,2], [2,3]))', 1, 3);
INSERT INTO test(content, language, task_id) VALUES ('println(findDuplicates([1,2], [3,4]))', 1, 3);
INSERT INTO test(content, language, task_id) VALUES ('println(findDuplicates([1,2,3,4,5,6], [1,4,15,21,0]))', 1, 3);
INSERT INTO test(content, language, task_id) VALUES ('println(findDuplicates([1,2], [1,2]))', 1, 3);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << findDuplicates({1,2}, {2,3}) << endl;', 2, 3);
INSERT INTO test(content, language, task_id) VALUES ('cout << findDuplicates({1,2}, {3,4}) << endl;', 2, 3);
INSERT INTO test(content, language, task_id) VALUES ('cout << findDuplicates({1,2,3,4,5,6}, {1,4,15,21,0}) << endl;', 2, 3);
INSERT INTO test(content, language, task_id) VALUES ('cout << findDuplicates({1,2}, {1,2}) << endl;', 2, 3);
#------------task_4#------------int[] -1,-1\n3,-1,3,2\n0,0,0,0
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(arraysDiff(new int[]{1,2}, new int[]{2,3}));', 0, 4);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(arraysDiff(new int[]{1,2,3,4}, new int[]{-2,3,0,2}));', 0, 4);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(arraysDiff(new int[]{1,2,3,4}, new int[]{1,2,3,4}));', 0, 4);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(arraysDiff([1,2], [2,3]))', 1, 4);
INSERT INTO test(content, language, task_id) VALUES ('println(arraysDiff([1,2,3,4], [-2,3,0,2]))', 1, 4);
INSERT INTO test(content, language, task_id) VALUES ('println(arraysDiff([1,2,3,4], [1,2,3,4]))', 1, 4);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << arraysDiff({1,2}, {2,3}) << endl;', 2, 4);
INSERT INTO test(content, language, task_id) VALUES ('cout << arraysDiff({1,2,3,4}, {2,3,0,2}) << endl;', 2, 4);
INSERT INTO test(content, language, task_id) VALUES ('cout << arraysDiff({1,2,3,4}, {1,2,3,4}) << endl;', 2, 4);
#------------task_5#------------int[] 5,1,2,3\n7,5,12,3\n12,3\n3,12
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(rotateArray(new int[]{1,2,3,5}, 1));', 0, 5);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(rotateArray(new int[]{12,3,7,5}, 2));', 0, 5);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(rotateArray(new int[]{12,3}, 8));', 0, 5);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(rotateArray(new int[]{12,3}, 7));', 0, 5);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(rotateArray([1,2,3,5], 1))', 1, 5);
INSERT INTO test(content, language, task_id) VALUES ('println(rotateArray([12,3,7,5], 2))', 1, 5);
INSERT INTO test(content, language, task_id) VALUES ('println(rotateArray([12,3], 8))', 1, 5);
INSERT INTO test(content, language, task_id) VALUES ('println(rotateArray([12,3], 7))', 1, 5);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << rotateArray({1,2,3,5}, 1) << endl;', 2, 5);
INSERT INTO test(content, language, task_id) VALUES ('cout << rotateArray({12,3,7,5}, 2) << endl;', 2, 5);
INSERT INTO test(content, language, task_id) VALUES ('cout << rotateArray({12,3}, 8) << endl;', 2, 5);
INSERT INTO test(content, language, task_id) VALUES ('cout << rotateArray({12,3}, 7) << endl;', 2, 5);
#------------task_6#------------boolean true\ntrue\nfalse\nfalse
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(nestsCorrectness(„{()()}”));', 0, 6);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(nestsCorrectness(„{()[()]}”));', 0, 6);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(nestsCorrectness(„{()()}]”));', 0, 6);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(nestsCorrectness(„{()(()}”));', 0, 6);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(nestsCorrectness(„{()()}”))', 1, 6);
INSERT INTO test(content, language, task_id) VALUES ('println(nestsCorrectness(„{()[()]}”))', 1, 6);
INSERT INTO test(content, language, task_id) VALUES ('println(nestsCorrectness(„{()()}]”))', 1, 6);
INSERT INTO test(content, language, task_id) VALUES ('println(nestsCorrectness(„{()(()}”))', 1, 6);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << nestsCorrectness(„{()()}”) << endl;', 2, 6);
INSERT INTO test(content, language, task_id) VALUES ('cout << nestsCorrectness(„{()[()]}”) << endl;', 2, 6);
INSERT INTO test(content, language, task_id) VALUES ('cout << nestsCorrectness(„{()()}]”) << endl;', 2, 6);
INSERT INTO test(content, language, task_id) VALUES ('cout << nestsCorrectness(„{()(()}”) << endl;', 2, 6);
#------------task_7#------------String[] "1,3","1,2","3,2","1,3","2,1","2,3","1,3"
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(hanoiTower(3));', 0, 7);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(hanoiTower(3))', 1, 7);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << hanoiTower(3) << endl;', 2, 7);
#------------task_8#------------int 72\n8176\n12\n36
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(lcm(24,36));', 0, 8);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(lcm(112,73));', 0, 8);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(lcm(12,12));', 0, 8);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(lcm(0,36));', 0, 8);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(lcm(24,36))', 1, 8);
INSERT INTO test(content, language, task_id) VALUES ('println(lcm(112,73))', 1, 8);
INSERT INTO test(content, language, task_id) VALUES ('println(lcm(12,12))', 1, 8);
INSERT INTO test(content, language, task_id) VALUES ('println(lcm(0,36))', 1, 8);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << lcm(24,36) << endl;', 2, 8);
INSERT INTO test(content, language, task_id) VALUES ('cout << lcm(112,73) << endl;', 2, 8);
INSERT INTO test(content, language, task_id) VALUES ('cout << lcm(12,12) << endl;', 2, 8);
INSERT INTO test(content, language, task_id) VALUES ('cout << lcm(0,36) << endl;', 2, 8);
#------------task_9#------------int 12\n1\n12\n5
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(gcd(24,36));', 0, 9);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(gcd(112,73));', 0, 9);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(gcd(12,12));', 0, 9);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(gcd(15,125));', 0, 9);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(gcd(24,36))', 1, 9);
INSERT INTO test(content, language, task_id) VALUES ('println(gcd(112,73))', 1, 9);
INSERT INTO test(content, language, task_id) VALUES ('println(gcd(12,12))', 1, 9);
INSERT INTO test(content, language, task_id) VALUES ('println(gcd(15,125))', 1, 9);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << gcd(24,36) << endl;', 2, 9);
INSERT INTO test(content, language, task_id) VALUES ('cout << gcd(112,73) << endl;', 2, 9);
INSERT INTO test(content, language, task_id) VALUES ('cout << gcd(12,12) << endl;', 2, 9);
INSERT INTO test(content, language, task_id) VALUES ('cout << gcd(15,125) << endl;', 2, 9);
#------------task_10#------------int 0\n1\n1144\n4181
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(fibonacci(0));', 0, 10);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(fibonacci(1));', 0, 10);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(fibonacci(2));', 0, 10);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(fibonacci(12));', 0, 10);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(fibonacci(19));', 0, 10);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(fibonacci(0))', 1, 10);
INSERT INTO test(content, language, task_id) VALUES ('println(fibonacci(1))', 1, 10);
INSERT INTO test(content, language, task_id) VALUES ('println(fibonacci(2))', 1, 10);
INSERT INTO test(content, language, task_id) VALUES ('println(fibonacci(12))', 1, 10);
INSERT INTO test(content, language, task_id) VALUES ('println(fibonacci(19))', 1, 10);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << fibonacci(0) << endl;', 2, 10);
INSERT INTO test(content, language, task_id) VALUES ('cout << fibonacci(1) << endl;', 2, 10);
INSERT INTO test(content, language, task_id) VALUES ('cout << fibonacci(2) << endl;', 2, 10);
INSERT INTO test(content, language, task_id) VALUES ('cout << fibonacci(12) << endl;', 2, 10);
INSERT INTO test(content, language, task_id) VALUES ('cout << fibonacci(19) << endl;', 2, 10);
#------------task_11#------------char a\nb\nf\na
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(mostCommonSign(„aaasrvssaa”));', 0, 11);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(mostCommonSign(„aabbcdewv”));', 0, 11);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(mostCommonSign(„ffffff”));', 0, 11);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(mostCommonSign(„a”));', 0, 11);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(mostCommonSign(„aaasrvssaa”))', 1, 11);
INSERT INTO test(content, language, task_id) VALUES ('println(mostCommonSign(„aabbcdewv”))', 1, 11);
INSERT INTO test(content, language, task_id) VALUES ('println(mostCommonSign(„ffffff”))', 1, 11);
INSERT INTO test(content, language, task_id) VALUES ('println(mostCommonSign(„a”))', 1, 11);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << mostCommonSign(„aaasrvssaa”) << endl;', 2, 11);
INSERT INTO test(content, language, task_id) VALUES ('cout << mostCommonSign(„aabbcdewv”) << endl;', 2, 11);
INSERT INTO test(content, language, task_id) VALUES ('cout << mostCommonSign(„ffffff”) << endl;', 2, 11);
INSERT INTO test(content, language, task_id) VALUES ('cout << mostCommonSign(„a”) << endl;', 2, 11);
#------------task_12#------------int 2\n3\n1\n1\n0
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(numberOfWords(“kaktuskaktus”));', 0, 12);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(numberOfWords(“ayuaksfkstkfykukspttkua”));', 0, 12);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(numberOfWords(“kaktus”));', 0, 12);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(numberOfWords(“kaktuskatus”));', 0, 12);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(numberOfWords(“katus”));', 0, 12);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(numberOfWords(“kaktuskaktus”))', 1, 12);
INSERT INTO test(content, language, task_id) VALUES ('println(numberOfWords(“ayuaksfkstkfykukspttkua”))', 1, 12);
INSERT INTO test(content, language, task_id) VALUES ('println(numberOfWords(“kaktus”))', 1, 12);
INSERT INTO test(content, language, task_id) VALUES ('println(numberOfWords(“kaktuskatus”))', 1, 12);
INSERT INTO test(content, language, task_id) VALUES ('println(numberOfWords(“katus”))', 1, 12);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << numberOfWords(“kaktuskaktus”) << endl;', 2, 12);
INSERT INTO test(content, language, task_id) VALUES ('cout << numberOfWords(“ayuaksfkstkfykukspttkua”) << endl;', 2, 12);
INSERT INTO test(content, language, task_id) VALUES ('cout << numberOfWords(“kaktus”) << endl;', 2, 12);
INSERT INTO test(content, language, task_id) VALUES ('cout << numberOfWords(“kaktuskatus”) << endl;', 2, 12);
INSERT INTO test(content, language, task_id) VALUES ('cout << numberOfWords(“katus”) << endl;', 2, 12);
#------------task_13#------------boolean
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(isPalindrome(„kajak”));', 0, 13);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(isPalindrome(„kkk”));', 0, 13);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(isPalindrome(„kajakk”));', 0, 13);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(isPalindrome(„oko”));', 0, 13);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(isPalindrome(„fsdreqgtw”));', 0, 13);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(isPalindrome(„kajak”))', 1, 13);
INSERT INTO test(content, language, task_id) VALUES ('println(isPalindrome(„kkk”))', 1, 13);
INSERT INTO test(content, language, task_id) VALUES ('println(isPalindrome(„kajakk”))', 1, 13);
INSERT INTO test(content, language, task_id) VALUES ('println(isPalindrome(„oko”))', 1, 13);
INSERT INTO test(content, language, task_id) VALUES ('println(isPalindrome(„fsdreqgtw”))', 1, 13);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << isPalindrome(„kajak”) << endl;', 2, 13);
INSERT INTO test(content, language, task_id) VALUES ('cout << isPalindrome(„kkk”) << endl;', 2, 13);
INSERT INTO test(content, language, task_id) VALUES ('cout << isPalindrome(„kajakk”) << endl;', 2, 13);
INSERT INTO test(content, language, task_id) VALUES ('cout << isPalindrome(„oko”) << endl;', 2, 13);
INSERT INTO test(content, language, task_id) VALUES ('cout << isPalindrome(„fsdreqgtw”) << endl;', 2, 13);
#------------task_14#------------String tset\ns\ntrevniot\nkajak
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(invertedString(„test”));', 0, 14);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(invertedString(„s”));', 0, 14);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(invertedString(„toinvert”));', 0, 14);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(invertedString(„kajak”));', 0, 14);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(invertedString(„test”))', 1, 14);
INSERT INTO test(content, language, task_id) VALUES ('println(invertedString(„s”))', 1, 14);
INSERT INTO test(content, language, task_id) VALUES ('println(invertedString(„toinvert”))', 1, 14);
INSERT INTO test(content, language, task_id) VALUES ('println(invertedString(„kajak”))', 1, 14);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << invertedString(„test”) << endl;', 2, 14);
INSERT INTO test(content, language, task_id) VALUES ('cout << invertedString(„s”) << endl;', 2, 14);
INSERT INTO test(content, language, task_id) VALUES ('cout << invertedString(„toinvert”) << endl;', 2, 14);
INSERT INTO test(content, language, task_id) VALUES ('cout << invertedString(„kajak”) << endl;', 2, 14);
#------------task_15#------------int 7\n1\n0\n3
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestRepetitionSeq(„siemmmmmmmaaallalala”));', 0, 15);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestRepetitionSeq(„abcdefghij”));', 0, 15);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestRepetitionSeq(„”));', 0, 15);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestRepetitionSeq(„abcccedeaaa”));', 0, 15);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(longestRepetitionSeq(„siemmmmmmmaaallalala”))', 1, 15);
INSERT INTO test(content, language, task_id) VALUES ('println(longestRepetitionSeq(„abcdefghij”))', 1, 15);
INSERT INTO test(content, language, task_id) VALUES ('println(longestRepetitionSeq(„”))', 1, 15);
INSERT INTO test(content, language, task_id) VALUES ('println(longestRepetitionSeq(„abcccedeaaa”))', 1, 15);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << longestRepetitionSeq(„siemmmmmmmaaallalala”) << endl;', 2, 15);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestRepetitionSeq(„abcdefghij”) << endl;', 2, 15);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestRepetitionSeq(„”) << endl;', 2, 15);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestRepetitionSeq(„abcccedeaaa”) << endl;', 2, 15);
#------------task_16#------------int 4\n1\n0\n10
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(distinctChars(„aabbbcccddd”));', 0, 16);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(distinctChars(„aaaaa”));', 0, 16);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(distinctChars(„”));', 0, 16);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(distinctChars(„abcdefghij”));', 0, 16);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(distinctChars(„aabbbcccddd”))', 1, 16);
INSERT INTO test(content, language, task_id) VALUES ('println(distinctChars(„aaaaa”))', 1, 16);
INSERT INTO test(content, language, task_id) VALUES ('println(distinctChars(„”))', 1, 16);
INSERT INTO test(content, language, task_id) VALUES ('println(distinctChars(„abcdefghij”))', 1, 16);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << distinctChars(„aabbbcccddd”) << endl;', 2, 16);
INSERT INTO test(content, language, task_id) VALUES ('cout << distinctChars(„aaaaa”) << endl;', 2, 16);
INSERT INTO test(content, language, task_id) VALUES ('cout << distinctChars(„”) << endl;', 2, 16);
INSERT INTO test(content, language, task_id) VALUES ('cout << distinctChars(„abcdefghij”) << endl;', 2, 16);
#------------task_17#------------String jeden,dwa,trzy\nsiema;czesc;hej\njeden
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(concatArrays(new String[]{„jeden”,”dwa”,”trzy”}, \',\'));', 0, 17);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(concatArrays(new String[]{„siema”,”czesc”,”hej”}, \';\'));', 0, 17);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(concatArrays(new String[]{„jeden”}, \',\'));', 0, 17);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(concatArrays([„jeden”,”dwa”,”trzy”], \',\'))', 1, 17);
INSERT INTO test(content, language, task_id) VALUES ('println(concatArrays([„siema”,”czesc”,”hej”], \',\'))', 1, 17);
INSERT INTO test(content, language, task_id) VALUES ('println(concatArrays([„jeden”], \',\'))', 1, 17);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << concatArrays({„jeden”,”dwa”,”trzy”}, \',\') << endl;', 2, 17);
INSERT INTO test(content, language, task_id) VALUES ('cout << concatArrays({„siema”,"czesc”,”hej”}, \',\') << endl;', 2, 17);
INSERT INTO test(content, language, task_id) VALUES ('cout << concatArrays({„jeden”}, \',\') << endl;', 2, 17);
#------------task_18#------------int 4\n3\n0\n6\n6
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestCommonSubstring(„aatrala”, „wwatrasw”));', 0, 18);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestCommonSubstring(„ababc”, „babca”));', 0, 18);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestCommonSubstring(„abc”, „def”));', 0, 18);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestCommonSubstring(„abcdef”, „abcdef”));', 0, 18);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(longestCommonSubstring(„abcdefdsds”, „nbnbabcdef”));', 0, 18);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(longestCommonSubstring(„aatrala”, „wwatrasw”))', 1, 18);
INSERT INTO test(content, language, task_id) VALUES ('println(longestCommonSubstring(„ababc”, „babca”))', 1, 18);
INSERT INTO test(content, language, task_id) VALUES ('println(longestCommonSubstring(„abc”, „def”))', 1, 18);
INSERT INTO test(content, language, task_id) VALUES ('println(longestCommonSubstring(„abcdef”, „abcdef”))', 1, 18);
INSERT INTO test(content, language, task_id) VALUES ('println(longestCommonSubstring(„abcdefdsds”, „nbnbabcdef”))', 1, 18);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << longestCommonSubstring(„aatrala”, „wwatrasw”) << endl;', 2, 18);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestCommonSubstring(„ababc”, „babca”) << endl;', 2, 18);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestCommonSubstring(„abc”, „def”) << endl;', 2, 18);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestCommonSubstring(„abcdef”, „abcdef”) << endl;', 2, 18);
INSERT INTO test(content, language, task_id) VALUES ('cout << longestCommonSubstring(„abcdefdsds”, „nbnbabcdef”) << endl;', 2, 18);
#------------task_19#------------int 14\n3724\n4\n28
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertRomanToArabic(„XIV”));', 0, 19);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertRomanToArabic(„MMMDCCXXIV”));', 0, 19);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertRomanToArabic(„IV”));', 0, 19);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertRomanToArabic(„XXVIII”));', 0, 19);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(convertRomanToArabic(„XIV”))', 1, 19);
INSERT INTO test(content, language, task_id) VALUES ('println(convertRomanToArabic(„MMMDCCXXIV”))', 1, 19);
INSERT INTO test(content, language, task_id) VALUES ('println(convertRomanToArabic(„IV”))', 1, 19);
INSERT INTO test(content, language, task_id) VALUES ('println(convertRomanToArabic(„XXVIII”))', 1, 19);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << convertRomanToArabic(„XIV”) << endl;', 2, 19);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertRomanToArabic(„MMMDCCXXIV”) << endl;', 2, 19);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertRomanToArabic(„IV”) << endl;', 2, 19);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertRomanToArabic(„XXVIII”) << endl;', 2, 19);
#------------task_20#------------String XIV\nMMMDCCXXIV\nIV\nXXVIII
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertArabicToRoman(14));', 0, 20);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertArabicToRoman(3724));', 0, 20);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertArabicToRoman(4));', 0, 20);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(convertArabicToRoman(28));', 0, 20);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(convertArabicToRoman(14))', 1, 20);
INSERT INTO test(content, language, task_id) VALUES ('println(convertArabicToRoman(3724))', 1, 20);
INSERT INTO test(content, language, task_id) VALUES ('println(convertArabicToRoman(4))', 1, 20);
INSERT INTO test(content, language, task_id) VALUES ('println(convertArabicToRoman(28))', 1, 20);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << convertArabicToRoman(14) << endl;', 2, 20);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertArabicToRoman(14) << endl;', 2, 20);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertArabicToRoman(14) << endl;', 2, 20);
INSERT INTO test(content, language, task_id) VALUES ('cout << convertArabicToRoman(14) << endl;', 2, 20);
#------------task_21#------------int 6\n1\n6456
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(missingNumber(new int[]{1,2,3,4,5,7}));', 0, 21);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(missingNumber(new int[]{2,3,4,5,6,7}));', 0, 21);
INSERT INTO test(content, language, task_id) VALUES ('int[] numbers = new int[999999999];int counter=0;for(int i=1000000000;i>0;i--){if(i!=6456){numbers[counter]=i;counter++;}} System.out.println(missingNumber(numbers));', 0, 21);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(missingNumber([1,2,3,4,5,7]))', 1, 21);
INSERT INTO test(content, language, task_id) VALUES ('println(missingNumber([2,3,4,5,6,7]))', 1, 21);
INSERT INTO test(content, language, task_id) VALUES ('numbers = []\n\tfor i in range(1000000000, 1):\n\t\tif(i != 6456):\n\t\t\tnumbers.append(i)\n\tprintln(missingNumber(numbers))', 1, 21);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << missingNumber({1,2,3,4,5,7}) << endl;', 2, 21);
INSERT INTO test(content, language, task_id) VALUES ('cout << missingNumber({2,3,4,5,6,7}) << endl;', 2, 21);
INSERT INTO test(content, language, task_id) VALUES ('int numbers[999999999];int counter=0;for(int i=1000000000;i>0;i--){if(i!=6456) {numbers[counter]=i;counter++; }} cout << missingNumber(numbers) << endl;', 2, 21);
#------------task_22#------------int 5\n-1\n742621
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(itemIndeX(new int[]{1,2,3,4,7,5,2,7}, 5));', 0, 22);
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(itemIndeX(new int[]{1,2,3,4,7,5,2,7}, 15));', 0, 22);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(itemIndeX([1,2,3,4,7,5,2,7], 5))', 1, 22);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << itemIndeX({1,2,3,4,7,5,2,7}, 5) << endl;', 2, 22);
#------------task_23#------------String
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(closestPair(new int[]{}));', 0, 23);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(closestPair([]))', 1, 23);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << closestPair({}) << endl;', 2, 23);
#------------task_24#------------String "   *\n  ***\n *****\n*******"
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(pyramid(4));', 0, 24);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(pyramid(4))', 1, 24);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << pyramid(4) << endl;', 2, 24);
#------------task_25#------------int 15
#java
INSERT INTO test(content, language, task_id) VALUES ('System.out.println(mostCommonNumber(new String[]{"1,15","15,16"}));', 0, 25);
#python
INSERT INTO test(content, language, task_id) VALUES ('println(mostCommonNumber(["1,15","15,16"]))', 1, 25);
#cpp
INSERT INTO test(content, language, task_id) VALUES ('cout << mostCommonNumber({"1,15","15,16"}) << endl;', 2, 25);
