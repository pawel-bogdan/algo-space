# ARRAYS - 0
# STRINGS - 1
# STACKS - 2
# RECURSION - 3
# SORTING - 4
# OTHER - 5

# EASY - 0
# MEDIUM - 1
# HARD - 2

# Kategoria - Tablice
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (1, 'Najkrótszy wyraz', '<div class="task-explanation">    <p>        Znajdź najkrótszy wyraz w tablicy o N elementach. Jeśli występuje więcej niż jeden taki wyraz, zwróć ten, który wystąpił w tablicy jako pierwszy.    </p>    <div class="example">        Przykładowo dla <span class="example-code">words = ["Michał", "Ala", "kawaleria", "mucha"]</span>        <br>        program powinien zwrócić <span class="example-code">"Ala"</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                words jest niepustą tablicą tzn. N jest liczbą w zakresie [1, 100000]            </li>            <li>                Wszystkie elementy tablicy mają wartość (nie są nullami).            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', 'aaaa\n\naaaa\nc\nbbb', 0, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (2, 'Największa w tablicy', '<div class="task-explanation">    <p>        Znajdź największą liczbę w tablicy o rozmiarze N.    </p>    <div class="example">        Przykładowo dla <span class="example-code">numbers = [0, -2, 33, 18, 28, -4]</span>        <br>        program powinien zwrócić <span class="example-code">33</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                N jest liczbą z zakresu [1, 100000]            </li>            <li>                Wszystkie elementy tablicy mają wartość (nie są nullami).            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>','76\n47\n-3', 0, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (3, 'Powtórzenia w tablicy', '<div class="task-explanation">    <p>        Znajdź wszystkie liczby, które występują w obu tablicach.    </p>    <div class="example">        Przykładowo dla <span class="example-code">array1 = [1, 0, 1, 4, 19, 0, 8], array2 = [15, 1, -9, 8, 31, 5]</span>        <br>        program powinien zwrócić <span class="example-code">[1, 8]</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">array1 = [2, 1], array2 = [4, 0, 4]</span>        <br>        program powinien zwrócić <span class="example-code">[]</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                N jest liczbą w zakresie [1, 100000]            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', '2\n\n1,4\n1,2', 0, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (4, 'Różnica tablic', '<div class="task-explanation">    <p>        Znajdź różnicę dwóch tablic o tym samym rozmiarze zawierających liczby. Przez różnicę tablic rozumiemy tablicę zawierająca wyniki z odejmowania elementów podanych tablic znajdujących się na tych samych pozycjach.    </p>    <div class="example">        Przykładowo dla <span class="example-code">array1 = [1, 2], array2 = [2, 3]</span>        <br>        program powinien zwrócić <span class="example-code">[-1, -1]</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">array1 = [1, 2, 3, 4], array2 = [-2, 3, 0, 2]</span>        <br>        program powinien zwrócić <span class="example-code">[3, -1, 3, 2]</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                N jest liczbą w zakresie [1, 100000]            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', '-1,-1\n3,-1,3,2\n0,0,0,0', 0, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (5, 'Rotacja tablicy', '<div class="task-explanation">    <p>        Wykonaj rotację podanej tablicy o wartość K podaną w argumencie funkcji. Przez rotację tablicy o wartość K = 1 rozumiemy przesunięcie każdego elementu tablicy o jedną pozycję do przodu, przy czym ostatni element tablicy przechodzi na jej początek.    </p>    <div class="example">        Przykładowo dla <span class="example-code">array = [1, 2, 3, 4, 5]</span> oraz <span class="example-code">K = 3</span>        <br>        program powinien zwrócić <span class="example-code">[3, 4, 5, 1, 2]</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                K jest liczbą nieujemną tzn. K jest z zakresu [0, 100000]            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '5,1,2,3\n7,5,12,3\n12,3\n3,12', 0, 1);
# Kategoria - Stosy
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (6, 'Zagnieżdżenia', '<div class="task-explanation">    <p>        Na wejściu podane jest wyrażenie składające się z nawiasów trzech rodzajów: {},(),[]. Sprawdź czy każdy z nawiasów jest odpowiednio zamknięty, a całe wyrażenie jest poprawne.    </p>    <div class="example">        Przykładowo dla <span class="example-code">word = "{{()}}"</span>        <br>        program powinien zwrócić <span class="example-code">true</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">word = "{[{()}}]"</span>        <br>        program powinien zwrócić <span class="example-code">false</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                word jest niepustym słowem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>','true\ntrue\nfalse\nfalse', 2, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (7, 'Wieża Hanoi', '<div class="task-explanation">    <p>        Wieża Hanoi to zagadka matematyczna. Składa się z trzech kijków i kilku krążków o różnych rozmiarach, które można nasunąć na dowolne kijki. Układanka zaczyna się od ułożonych na pierwszym kijku krążków ułożonych patrząc od góry od najmniejszego do największego. Celem łamigłówki jest przeniesienie wszystkich dysków z pierwszego kijka na inny tak aby były ustawione w taki sam sposób jak na początku gry.        Przy czym należy zachować następujące zasady:        1. Nie można umieścić większego krążka na mniejszym.        2. Jednocześnie można przenosić tylko jeden krążek        Na wyjściu algorytm powinien zwrócić tablicę par indeksów. W każdej z par należy na pierwszej pozycji zapisać numer kijka (1,2 lub 3), z którego zdjęty został dysk, a na drugiej pozycji numer kijka, na który dysk został przeniesiony. Przykładowy element tablicy: „1,2”   </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', '"1,3","1,2","3,2","1,3","2,1","2,3","1,3"', 2, 1);
# Kategoria - Rekurencja
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (8, 'NWW', '<div class="task-explanation">    <p>        Znajdź najmniejszą wspólną wielokrotność dwóch liczb podanych na wejściu.    </p>    <div class="example">        Przykładowo dla <span class="example-code">firstNumber = 24</span> oraz <span class="example-code">secondNumber = 36</span>        <br>        program powinien zwrócić <span class="example-code">72</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', '72\n8176\n12\n0', 3, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (9, 'NWD', '<div class="task-explanation">    <p>        Znajdź największy wspólny dzielnik dwóch liczb podanych na wejściu.    </p>    <div class="example">        Przykładowo dla <span class="example-code">firstNumber = 24</span> oraz <span class="example-code">secondNumber = 36</span>        <br>        program powinien zwrócić <span class="example-code">12</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '12\n1\n12\n5', 3, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (10, 'Fibonacci', '<div class="task-explanation">    <p>        Znajdź n-tą liczbę ciągu Fibonacciego, gdzie n jest argumentem funkcji.    </p>    <div class="example">        Przykładowo dla <span class="example-code">n = 7</span>        <br>        program powinien zwrócić <span class="example-code">13</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące     założenia:        <ul>            </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', '0\n1\n1\n144\n4181', 3, 1);
# Kategoria - Ciągi znaków
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (11, 'Dominujący znak', '<div class="task-explanation">    <p>        Znajdź najczęściej pojawiający się w ciągu znak. Jeśli istnieje kilka znaków, które wystąpiły taką samą liczbę razy, zwróć ten który znalazł się w tablicy jako ostatni.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "abrakadabra"</span>        <br>        program powinien zwrócić <span class="example-code">''a''</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input nie jest nullem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>','a\nb\nf\na', 1, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (12, 'Kaktus', '<div class="task-explanation">    <p>        Mając podany ciąg znaków, sprawdź ile razy można ułożyć z niego wyraz „kaktus” używając każdej literki jeden raz.        🌵 🌵 🌵    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "kaktuskatus"</span>        <br>        program powinien zwrócić <span class="example-code">1</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">input = "ayuaksfkstkfykukspttkua"</span>        <br>        program powinien zwrócić <span class="example-code">3</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input nie jest nullem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '2\n3\n1\n1\n0', 1, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (13, 'Palindrom', '<div class="task-explanation">    <p>        Sprawdź, czy podany na wejściu ciąg znaków jest palindromem.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "kajak"</span>        <br>        program powinien zwrócić <span class="example-code">true</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">input = "kajakk"</span>        <br>        program powinien zwrócić <span class="example-code">false</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input nie jest nullem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>', 'true\ntrue\nfalse\ntrue\nfalse', 1, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (14, 'Odwrócenie ciągu', '<div class="task-explanation">    <p>        Odwróć podany na wejściu ciąg znaków.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "kot"</span>        <br>        program powinien zwrócić <span class="example-code">"tok"</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input nie jest nullem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Dominik Omański</div>    </div></div>','tset\ns\ntrevniot\nkajak', 1, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (15, 'Najdłuższy ciąg powtórzeń', '<div class="task-explanation">    <p>        Znajdź długość najdłuższego podciągu wejściowej wartości takiego, że wszystkei jego znaki są identyczne.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "aaabbbbccc"</span>        <br>        program powinien zwrócić <span class="example-code">4</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">word = "abcd"</span>        <br>        program powinien zwrócić <span class="example-code">1</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input jest niepustym słowem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '7\n1\n0\n3',1,1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (16, 'Unikalne znaki', '<div class="task-explanation">    <p>         Znajdź liczbę unikalnych znaków w ciągu podanym na wejściu.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = "aaaaa"</span>        <br>        program powinien zwrócić <span class="example-code">1</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input jest słowem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>','4\n1\n0\n10',1,1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (17, 'Łączenie ciągów', '<div class="task-explanation">    <p>        Połącz elementy tablicy w jeden ciąg rozdzielając je separatorem podanym w argumencie funkcji.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = ["a", "b", ";"]</span>        <br>        program powinien zwrócić <span class="example-code">a;b;c</span>.    </div>    <div class="example">        Przykładowo dla <span class="example-code">input = ["abcd"]</span>        <br>        program powinien zwrócić <span class="example-code">abcd</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input jest niepustą tablicą słów            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', 'jeden,dwa,trzy\nsiema;czesc;hej\njeden', 1, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (18, 'Najdłuższy wspólny podciąg', '<div class="task-explanation">    <p>        Znajdź długość najdłuższego wspólnego podciągu dwóch tablic podanych w argumentach funkcji.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input1 = "ababc" input2="babca"</span>        <br>        program powinien zwrócić <span class="example-code">3</span>.    </div>        <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input1 i input2 są niepustymi słowami            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '4\n3\n0\n6\n6', 1, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (19, 'Rzymskie na arabskie', '<div class="task-explanation">    <p>        Zamień podaną na wejściu liczbę rzymską na liczbę arabską.    </p>    <div class="example">        Przykładowo dla <span class="example-code">roman = "XIV"</span>        <br>        program powinien zwrócić <span class="example-code">14</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                roman jest niepustym słowem            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '14\n3724\n4\n28', 1, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (20, 'Arabskie na rzymskie', '<div class="task-explanation">    <p>        Zamień podaną na wejściu liczbę arabską na liczbę rzymską.    </p>    <div class="example">        Przykładowo dla <span class="example-code">arabic = 14</span>        <br>        program powinien zwrócić <span class="example-code">"XIV"</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                arabic jest liczbą dodatnią w zakresie od 1 do 3999           </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', 'XIV\nMMMDCCXXIV\nIV\nXXVIII', 1, 1);
# Kategoria - Sortowanie
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (21, 'Brakującą liczba w tablicy.', '<div class="task-explanation">    <p>        W tablicy wejściowej znajdują się liczby naturalne od 1 do n, brakuje w niej jednej z liczb, znajdź ją i zwróć.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = [1, 6, 2, 3, 5]</span>        <br>        program powinien zwrócić <span class="example-code">4</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input jest niepustą tablicą zawierającą liczby od 1 do n z wyłączeniem jednej losowo wybranej liczby            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '6\n1\n6456', 4, 1);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (22, 'BinSearch', '<div class="task-explanation">    <p>       W podanej na wejściu uporządkowanej tablicy znajdź indeks na którym znajduje się element podany w argumencie funkcji, jeśli element znalazł się w tablicy kilkukrotnie zwróć indeks jego ostatniego wystąpienia.        Elementy tablicy indeksowane są od zera. Jeśli element nie wystąpił ani razu zwróc wartość -1.    </p>    <div class="example">        Przykładowo dla <span class="example-code">input = [1, 2, 3, 5, 6] item=5</span>        <br>        program powinien zwrócić <span class="example-code">3</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                input jest niepustą uporządkowaną rosnąco tablicą zawierającą liczby              </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '4\n-1', 4, 0);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (23, 'Najmniejsza różnica', '<div class="task-explanation">    <p>        Znajdź taką parę liczb w wejściowej tablicy, między którymi różnica jest najmniejsza. Liczby zwróć w postaci ciągu znaków, np. dla pary liczb 5 i 6 należy zwrócić ciąg „5 6”.        Jeżeli istnieje więcej niż jedna taka para liczb zwróć tą, której suma liczb jest najmniejsza    </p>    <div class="example"> Przykładowo dla <span class="example-code">input = [1,5,12,8,3,9,3,5]</span> <br>        program powinien zwrócić <span class="example-code">"8 9"</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                w tablicy wejściowej znajdują się conajmniej dwa elementy            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '8 9\n1 2', 4, 1);
# Kategoria - Inne
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (24, 'Piramidka', '<div class="task-explanation">    <p>        Wypisz na wyjściu piramidkę utworzoną z symboli * o wysokości podanej na wejściu. Dla wysokości height=3 piramidka wygląda w następujący sposób:<br>     *<br>    ***<br>   *****<br>    </p>        <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                height jest dodatnią liczbą całkowitą            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '   *   \n  ***  \n ***** \n*******',5,2);
INSERT INTO task(id, name, content, expected_output, category, difficulty) VALUES (25, 'Najczęściej powtarzająca się liczba', '<div class="task-explanation">    <p>        Na wejściu funkcji znajduje się tablica ciągów znaków, każdy jej element zawiera parę liczb oddzieloną przecinkiem, np. „1,12”. Każda z takich par liczb reprezentuje domknięty przedział liczb naturalnych.        Znajdź liczbę która wystąpiła najczęściej razy we wszystkich przedziałach zawartych w całej tablicy wejściowej.        Jeśli istnieje więcej niż jedna taka liczba zwróć najmniejszą z nich.    </p>    <div class="example"> Przykładowo dla <span class="example-code">pairs = ["1,15","15,16"]</span> <br>        program powinien zwrócić <span class="example-code">15</span>.    </div>    <div class="assumptions">        Możesz przyjąć następujące założenia:        <ul>            <li>                pairs jest niepustą tablicą ciągów znaków reprezentujących zbiór liczb            </li>        </ul>    </div>    <div class="footer">        <div>algo-space</div>        <div class="author">Paweł Bogdan</div>    </div></div>', '15', 5, 2);
