drop database if exists karutaya;
create database karutaya;
use karutaya;

create table users(
userid int primary key auto_increment,
email varchar(255),
password varchar(255),
username varchar(255),
deleteflag int default 0
);

create table address(
addressid int not null primary key auto_increment,
userid int,
addressname varchar(50),
addressnumber varchar(16),
address varchar(255),
foreign key(userid) references users(userid)
);

create table items(
itemid int primary key auto_increment,
itemname varchar(50),
author varchar(16),
price decimal,
stocks int,
sales int default 0,
itemimg varchar(50),
deleted int,
special1 int,
special2 int,
special3 int,
special4 int
);


create table sessionid(
sessionid int
);

create table cart(
sessionid int,
itemid int,
quantity int,
foreign key(itemid) references items(itemid)
);


create table purchaseoutlines(
purchaseoutlineid int primary key auto_increment,
userid int,
total int,
addressid int(10),
howdeliver varchar(10),
howpay varchar(10),
creditnumber varchar(20),
purchasetime datetime default current_timestamp,
foreign key(userid) references users(userid)
);


create table purchasedetails(
purchaseoutlineid int,
itemid int,
quantity int,
foreign key(purchaseoutlineid) references purchaseoutlines(purchaseoutlineid),
foreign key(itemid) references items(itemid)
);

INSERT INTO users VALUES(1,"aaa@gmail.com","111","山田太郎",0);

INSERT INTO address VALUES(1,1,"山田家","１２３４５６７","東京都文京区弥生１－１ハイツサトウ３３４");


INSERT INTO items(itemid,itemname,author,price,stocks,itemimg) VALUES
(1,"あきのたの かりおのいおの とまをあらみ わがころもでは つゆにぬれつつ","天智天皇",2,1000,"img/001.jpg"),
(2,"はるすぎて なつきにけらし しろたえの ころもほすちょう あまのかぐやま","持統天皇",2,1000,"img/002.jpg"),
(3,"あしびきの やまどりのおの しだりおの ながながしよを ひとりかもねん","柿本人麻呂",2,1000,"img/003.jpg"),
(4,"たごのうらに うちいでてみれば しろたえの ふじのたかねに ゆきはふりつつ","山部赤人",2,1000,"img/004.jpg"),
(5,"おくやまに もみじふみわけ なくしかの こえきくときぞ あきはかなしき","猿丸大夫",2,1000,"img/005.jpg"),
(6,"かささぎの わたせるはしに おくしもの しろきをみれば よぞふけにける","中納言家持",2,1000,"img/006.jpg"),
(7,"あまのはら ふりさけみれば かすがなる みかさのやまに いでしつきかも","安倍仲麿",2,1000,"img/007.jpg"),
(8,"わがいおは みやこのたつみ しかぞすむ よをうじやまと ひとはいうなり","喜撰法師",2,1000,"img/008.jpg"),
(9," はなのいろは うつりにけりな いたずらに わがみよにふる ながめせしまに","小野小町",2,1000,"img/009.jpg"),
(10,"これやこの ゆくもかえるも わかれては しるもしらぬも おおさかのせき","蝉丸",2,1000,"img/010.jpg"),
(11,"わたのはら やそしまかけて こぎいでぬと ひとにはつげよ あまのつりぶね","参議篁",2,1000,"img/011.jpg"),
(12,"あまつかぜ くものかよいじ ふきとじよ おとめのすがた しばしとどめん","僧正遍昭",2,1000,"img/012.jpg"),
(13,"つくばねの みねよりおつる みなのがわ こいぞつもりて ふちとなりぬる","陽成院",2,1000,"img/013.jpg"),
(14,"みちのくの しのぶもじずり たれゆえに みだれそめにし われならなくに","河原左大臣",2,1000,"img/014.jpg"),
(15,"きみがため はるののにいでて わかなつむ わがころもでに ゆきはふりつつ","光孝天皇",2,1000,"img/015.jpg"),
(16,"たちわかれ いなばのやまの みねにおうる まつとしきかば いまかえりこん","中納言行平",2,1000,"img/016.jpg"),
(17,"ちはやぶる かみよもきかず たつたがわ からくれないに みずくくるとは","在原業平朝臣",2,1000,"img/017.jpg"),
(18,"すみのえの きしによるなみ よるさえや ゆめのかよいじ ひとめよくらん","藤原敏行朝臣",2,1000,"img/018.jpg"),
(19,"なにわがた みじかきあしの ふしのまも あわでこのよを すぐしてよとや","伊勢",2,1000,"img/019.jpg"),
(20,"わびぬれば いまはたおなじ なにわなる みをつくしても あわんとぞおもう","元良親王",2,1000,"img/020.jpg"),
(21,"いまこんと いいしばかりに ながつきの ありあけのつきを まちいでつるかな","素性法師",2,1000,"img/021.jpg"),
(22,"ふくからに あきのくさきの しおるれば むべやまかぜを あらしというらん","文屋康秀",2,1000,"img/022.jpg"),
(23,"つきみれば ちぢにものこそ かなしけれ わがみひとつの あきにはあらねど","大江千里",2,1000,"img/023.jpg"),
(24,"このたびは ぬさもとりあえず たむけやま もみじのにしき かみのまにまに","菅家",2,1000,"img/024.jpg"),
(25,"なにしおわば おおさかやまの さねかづら ひとにしられで くるよしもがな","三条右大臣",2,1000,"img/025.jpg"),
(26,"おぐらやま みねのもみじば こころあらば いまひとたびの みゆきまたなん","貞信公",2,1000,"img/026.jpg"),
(27,"みかのはら わきてながるる いずみがわ いつみきとてか こいしかるらん","中納言兼輔",2,1000,"img/027.jpg"),
(28,"やまざとは ふゆぞさびしさ まさりける ひとめもくさも かれぬとおもえば","源宗于朝臣",2,1000,"img/028.jpg"),
(29,"こころあてに おらばやおらん はつしもの おきまどわせる しらぎくのはな","凡河内躬恒",2,1000,"img/029.jpg"),
(30,"ありあけの つれなくみえし わかれより あかつきばかり うきものはなし","壬生忠岑",2,1000,"img/030.jpg"),
(31,"あさぼらけ ありあけのつきと みるまでに よしののさとに ふれるしらゆき","坂上是則",2,1000,"img/031.jpg"),
(32,"やまがわに かぜのかけたる しがらみは ながれもあえぬ もみじなりけり","春道列樹",2,1000,"img/032.jpg"),
(33,"ひさかたの ひかりのどけき はるのひに しずごころなく はなのちるらん","紀友則",2,1000,"img/033.jpg"),
(34,"たれをかも しるひとにせん たかさごの まつもむかしの ともならなくに","藤原興風",2,1000,"img/034.jpg"),
(35,"ひとはいさ こころもしらず ふるさとは はなぞむかしの かににおいける","紀貫之",2,1000,"img/035.jpg"),
(36,"なつのよは まだよいながら あけぬるを くものいずこに つきやどるらん","清原深養父",2,1000,"img/036.jpg"),
(37,"しらつゆに かぜのふきしく あきののは つらぬきとめぬ たまぞちりける","文屋朝康",2,1000,"img/037.jpg"),
(38,"わすらるる みをばおもわず ちかいてし ひとのいのちの おしくもあるかな","右近",2,1000,"img/038.jpg"),
(39,"あさじうの おののしのはら しのぶれど あまりてなどか ひとのこいしき","参議等",2,1000,"img/039.jpg"),
(40,"しのぶれど いろにいでにけり わがこいは ものやおもうと ひとのとうまで","平兼盛",2,1000,"img/040.jpg"),
(41,"こいすちょう わがなはまだき たちにけり ひとしれずこそ おもいそめしか ","壬生忠見",2,1000,"img/041.jpg"),
(42,"ちぎりきな かたみにそでを しぼりつつ すえのまつやま なみこさじとは","清原元輔",2,1000,"img/042.jpg"),
(43,"あいみての のちのこころに くらぶれば むかしはものを おもわざりけり","権中納言敦忠",2,1000,"img/043.jpg"),
(44,"おおことの たえてしなくは なかなかに ひとをもみをも うらみざらまし","中納言朝忠",2,1000,"img/044.jpg"),
(45,"あわれとも いうべきひとは おもおえで みのいたずらに なりぬべきかな","謙徳公",2,1000,"img/045.jpg"),
(46,"ゆらのとを わたるふなびと かじをたえ ゆくえもしらぬ こいのみちかな","曽禰好忠",2,1000,"img/046.jpg"),
(47,"やえむぐら しげれるやどの さびしきに ひとこそみえね あきはきにけり","恵慶法師",2,1000,"img/047.jpg"),
(48,"かぜをいたみ いわうつなみの おのれのみ くだけてものを おもうころかな ","源重之",2,1000,"img/048.jpg"),
(49,"みかきもり えじのたくひの よるはもえ ひるはきえつつ ものをこそおもえ","大中臣能宣朝臣",2,1000,"img/049.jpg"),
(50,"きみがため おしからざりし いのちさえ ながくもがなと おもいけるかな","藤原義孝",2,1000,"img/050.jpg"),
(51,"","",2,1000,"img/051.jpg"),
(52,"","",2,1000,"img/052.jpg"),
(53,"","",2,1000,"img/053.jpg"),
(54,"","",2,1000,"img/054.jpg"),
(55,"","",2,1000,"img/055.jpg"),
(56,"","",2,1000,"img/056.jpg"),
(57,"","",2,1000,"img/057.jpg"),
(58,"","",2,1000,"img/058.jpg"),
(59,"","",2,1000,"img/059.jpg"),
(60,"","",2,1000,"img/060.jpg"),
(61,"","",2,1000,"img/061.jpg"),
(62,"","",2,1000,"img/062.jpg"),
(63,"","",2,1000,"img/063.jpg"),
(64,"","",2,1000,"img/064.jpg"),
(65,"","",2,1000,"img/065.jpg"),
(66,"","",2,1000,"img/066.jpg"),
(67,"","",2,1000,"img/067.jpg"),
(68,"","",2,1000,"img/068.jpg"),
(69,"","",2,1000,"img/069.jpg"),
(70,"","",2,1000,"img/070.jpg"),
(71,"","",2,1000,"img/071.jpg"),
(72,"","",2,1000,"img/072.jpg"),
(73,"","",2,1000,"img/073.jpg"),
(74,"","",2,1000,"img/074.jpg"),
(75,"","",2,1000,"img/075.jpg"),
(76,"","",2,1000,"img/076.jpg"),
(77,"","",2,1000,"img/077.jpg"),
(78,"","",2,1000,"img/078.jpg"),
(79,"","",2,1000,"img/079.jpg"),
(80,"","",2,1000,"img/080.jpg"),
(81,"","",2,1000,"img/081.jpg"),
(82,"","",2,1000,"img/082.jpg"),
(83,"","",2,1000,"img/083.jpg"),
(84,"","",2,1000,"img/084.jpg"),
(85,"","",2,1000,"img/085.jpg"),
(86,"","",2,1000,"img/086.jpg"),
(87,"","",2,1000,"img/087.jpg"),
(88,"","",2,1000,"img/088.jpg"),
(89,"","",2,1000,"img/089.jpg"),
(90,"","",2,1000,"img/090.jpg"),
(91,"","",2,1000,"img/091.jpg"),
(92,"","",2,1000,"img/092.jpg"),
(93,"","",2,1000,"img/093.jpg"),
(94,"","",2,1000,"img/094.jpg"),
(95,"","",2,1000,"img/095.jpg"),
(96,"","",2,1000,"img/096.jpg"),
(97,"","",2,1000,"img/097.jpg"),
(98,"","",2,1000,"img/098.jpg"),
(99,"","",2,1000,"img/099.jpg"),
(100,"","",2,1000,"img/100.jpg");

UPDATE items SET special1=1 where itemid=2;
UPDATE items SET special1=1 where itemid=9;
UPDATE items SET special1=1 where itemid=19;
UPDATE items SET special1=1 where itemid=38;
UPDATE items SET special1=1 where itemid=53;
UPDATE items SET special1=1 where itemid=54;
UPDATE items SET special1=1 where itemid=56;
UPDATE items SET special1=1 where itemid=57;
UPDATE items SET special1=1 where itemid=58;
UPDATE items SET special1=1 where itemid=59;
UPDATE items SET special1=1 where itemid=60;
UPDATE items SET special1=1 where itemid=61;
UPDATE items SET special1=1 where itemid=62;
UPDATE items SET special1=1 where itemid=65;
UPDATE items SET special1=1 where itemid=67;
UPDATE items SET special1=1 where itemid=72;
UPDATE items SET special1=1 where itemid=80;
UPDATE items SET special1=1 where itemid=88;
UPDATE items SET special1=1 where itemid=89;
UPDATE items SET special1=1 where itemid=90;
UPDATE items SET special1=1 where itemid=92;



