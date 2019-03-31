INSERT INTO category (code, name, parent_id)
VALUES ('0',
        'Общий отдел. Наука и знание. Организация. Информационные технологии. Информация. Документация. Библиотечное дело. Учреждения. Публикации в целом',
        null);

INSERT INTO category (code, name, parent_id)
VALUES ('00',
        'Общие вопросы науки и культуры. Пропедевтика',
        (SELECT id FROM category WHERE code = '0'));


INSERT INTO category (code, name, parent_id)
VALUES ('001',
        'Наука и знание в целом. Организация умственного труда',
        (SELECT id FROM category WHERE code = '00'));

INSERT INTO category (code, name, parent_id)
VALUES ('001.1',
        'Общее понятие о науке и знании',
        (SELECT id FROM category WHERE code = '001'));

INSERT INTO category (code, name, parent_id)
VALUES ('001.2',
        'Взаимосвязь отдельных научных дисциплин',
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.3',
        'Значение науки и знаний в целом. Ценность, использование, место в обществе. Защита науки',
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.4',
        'Язык науки. Научная терминология. Номенклатура',
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.5',
        'Научные теории, гипотезы и системы. Установление зависимости между научными фактами',
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.6',
        'Научные законы. Исключение из законов',
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.7',
        null,
        (SELECT id FROM category WHERE code = '001'));


INSERT INTO category (code, name, parent_id)
VALUES ('001.8',
        'Общая методология. Научные и технические методы исследований, изучения, поисков и дискуссий. Научный анализ и синтез',
        (SELECT id FROM category WHERE code = '001'));

INSERT INTO category (code, name, parent_id)
VALUES ('001.9',
        'Распространение знаний',
        (SELECT id FROM category WHERE code = '001'));

INSERT INTO category (code, name, parent_id)
VALUES ('002',
        'Распространение знаний',
        (SELECT id FROM category WHERE code = '00'));

INSERT INTO category (code, name, parent_id)
VALUES ('003',
        'Системы письма и письменности. Знаки и символы. Семиотика в целом. Коды. Графическое представление мысли',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('004', 'Информационные технологии. Вычислительная техника. Обработка данных',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.1', null,
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.2', 'Архитектура вычислительных машин',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.3', 'Аппаратные средства. Техническое обеспечение',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.4', 'Программные средства',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.5',
        'Человеко-машинное взаимодействие. Человеко-машинный интерфейс. Пользовательский интерфейс. Операционная среда пользователя',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.6', 'Данные',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.7', 'Связь компьютеров. Сети ЭВМ. Вычислительные сети',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.8', 'Искусственный интеллект',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('004.9', 'Прикладные информационные (компьютерные) технологии. Методы, основанные на применении компьютеров',
        (SELECT id FROM category WHERE code = '004'));
INSERT INTO category (code, name, parent_id)
VALUES ('005', 'Управление. Менеджмент',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('006',
        'Стандартизация продукции, процессов, мер, весов и времени. Стандарты. Технические требования. Нормы и правила. Рекомендации',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('007', 'Деятельность и организация. Общая теория связи и управления (кибернетика)',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('008', 'Цивилизация. Культура. Прогресс',
        (SELECT id FROM category WHERE code = '00'));
INSERT INTO category (code, name, parent_id)
VALUES ('009', 'Гуманитарные науки в целом',
        (SELECT id FROM category WHERE code = '00'));

INSERT INTO category (code, name, parent_id)
VALUES ('01', 'Библиография и библиографии. Каталоги',
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('02', 'Библиотечное дело',
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('03', null,
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('030', 'Справочные издания общего типа. Энциклопедии, словари',
        (SELECT id FROM category WHERE code = '03'));
INSERT INTO category (code, name, parent_id)
VALUES ('04', null,
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('05', null,
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('050', 'Сериальные и продолжающиеся издания. Периодика',
        (SELECT id FROM category WHERE code = '05'));
INSERT INTO category (code, name, parent_id)
VALUES ('06', 'Организации вообще. Ассоциации. Музеи',
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('07', null,
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('070', 'Газеты. Пресса. Журналистика',
        (SELECT id FROM category WHERE code = '07'));
INSERT INTO category (code, name, parent_id)
VALUES ('08', 'Издания смешанного содержания. Сборники',
        (SELECT id FROM category WHERE code = '0'));
INSERT INTO category (code, name, parent_id)
VALUES ('09', 'Рукописи. Редкие книги',
        (SELECT id FROM category WHERE code = '0'));


INSERT INTO category (code, name, parent_id)
VALUES ('1', 'Философия. Психология',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('10', '101 Природа и роль философии',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('11', 'Метафизика',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('12',
        'Кардинальные вопросы философии: причинность, соотношение свободы и необходимости, телеология, конечность/бесконечность мира, смысл жизни, сущность души',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('13', 'Философия разума и духа. Метафизика духовной жизни',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('14', 'Философские системы и концепции',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('15', null,
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('159', null,
        (SELECT id FROM category WHERE code = '15'));
INSERT INTO category (code, name, parent_id)
VALUES ('159.9', 'Психология',
        (SELECT id FROM category WHERE code = '159'));
INSERT INTO category (code, name, parent_id)
VALUES ('16', 'Логика. Теория познания. Методология и логика науки',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('17', 'Этика. Учение о морали. Практическая философия',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('18', '(Исключено.)',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('19', 'История философии',
        (SELECT id FROM category WHERE code = '1'));
INSERT INTO category (code, name, parent_id)
VALUES ('2', 'Религия. Богословие',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('20', '21 Доисторические и примитивные религии',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('22', 'Религии дальневосточного происхождения',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('23', 'Религии Индийского субконтинента. Индуистская религия в широком смысле',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('24', 'Буддизм',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('25', 'Религии античности. Второстепенные культы и религии',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('26', 'Иудаизм',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('27', 'Христианство',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('28', 'Ислам',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('29', 'Современные духовные течения',
        (SELECT id FROM category WHERE code = '2'));
INSERT INTO category (code, name, parent_id)
VALUES ('3',
        'Общественные науки. Статистика. Политика. Экономика. Торговля. Право. Государство. Военное дело. Социальное обеспечение. Страхование. Образование. Фольклор',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('30', 'Теория и методы общественных наук в целом. Социография',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('31', 'Демография. Социология. Статистика',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('32', 'Политика',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('33', 'Экономика. Экономические науки',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('34', 'Право. Юридические науки',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('35', 'Государственное административное управление. Военное дело',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('36',
        'Обеспечение духовных и материальных жизненных потребностей. Социальное обеспечение. Социальная помощь. Обеспечение жильем. Страхование',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('37', 'Воспитание. Обучение. Образование',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('38', '39 Этнография. Этнология. Нравы. Обычаи. Образ жизни. Фольклор',
        (SELECT id FROM category WHERE code = '3'));
INSERT INTO category (code, name, parent_id)
VALUES ('4', '(Резерв для будущего применения.)',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('5', 'Математика и естественные науки',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('50', 'Общие вопросы математических и естественных наук',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('51', 'Математика',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('52', 'Астрономия. Астрофизика. Исследование космического пространства. Геодезия',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('53', 'Физика',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('54', 'Химия. Кристаллография. Минералогия',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('55', 'Науки о земле. Геологические науки',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('56', 'Палеонтология',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('57', 'Биологические науки в целом',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('58', 'Ботаника',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('59', 'Зоология',
        (SELECT id FROM category WHERE code = '5'));
INSERT INTO category (code, name, parent_id)
VALUES ('6', 'Прикладные науки. Медицина. Технология',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('60', 'Биотехнология',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('61', 'Медицинские науки',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('62', 'Инженерное дело. Техника в целом',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('63', 'Сельское хозяйство. Лесное хозяйство. Охота. Рыбное хозяйство',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('64', 'Домашнее хозяйство. Домоводство. Коммунально-бытовое хозяйство',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('65', '(Исключено в 2003 г.)',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('66',
        'Химическая технология. Химическая промышленность. Пищевая промышленность. Металлургия. Родственные отрасли',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('67', 'Различные отрасли промышленности и ремёсел. Производство изделий из различных материалов',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('68', 'Отрасли промышленности и ремёсла для изготовления и обработки различных изделий',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('69', 'Строительство. Строительные материалы. Строительно-монтажные работы',
        (SELECT id FROM category WHERE code = '6'));
INSERT INTO category (code, name, parent_id)
VALUES ('7', 'Искусство. Развлечения. Зрелища. Спорт',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('70', null,
        (SELECT id FROM category WHERE code = '7'));

VALUES ('71',
        'Планировка. Районная и городская планировка. Планировка в масштабе страны. Ландшафтная и садово-парковая архитектура',
        (SELECT id FROM category WHERE code = '7'));

INSERT INTO category (code, name, parent_id)
VALUES ('72', 'Архитектура',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('73', 'Пластические искусства. Скульптура. Нумизматика',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('74', 'Рисование и черчение. Дизайн. Декоративно-прикладное искусство и художественные промыслы',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('75', 'Живопись',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('76', 'Графические искусства. Графика. Гравюра',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('77', 'Фотография и подобные процессы',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('78', 'Музыка',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('79', 'Развлечения. Зрелища. Игры. Спорт',
        (SELECT id FROM category WHERE code = '7'));
INSERT INTO category (code, name, parent_id)
VALUES ('8', 'Язык. Языкознание. Лингвистика. Литература',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('80', 'Общие вопросы лингвистики, литературы и филологии',
        (SELECT id FROM category WHERE code = '8'));
INSERT INTO category (code, name, parent_id)
VALUES ('801', 'Просодия. Стихосложение. Вспомогательные науки и источники филологии',
        (SELECT id FROM category WHERE code = '80'));
INSERT INTO category (code, name, parent_id)
VALUES ('808', 'Риторика. Эффективное использование языка',
        (SELECT id FROM category WHERE code = '80'));
INSERT INTO category (code, name, parent_id)
VALUES ('81', 'Языкознание и языки. Лингвистика',
        (SELECT id FROM category WHERE code = '8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811', 'Языки',
        (SELECT id FROM category WHERE code = '81'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.1/.8', 'Естественные языки',
        (SELECT id FROM category WHERE code = '811'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.11', 'Германские языки',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.111', 'Английский язык',
        (SELECT id FROM category WHERE code = '811.11'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.112', 'Другие западногерманские языки',
        (SELECT id FROM category WHERE code = '811.11'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.112.2', 'Немецкий язык',
        (SELECT id FROM category WHERE code = '811.112'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.112.5', 'Голландский язык. Нидерландский язык. Фламандский язык',
        (SELECT id FROM category WHERE code = '811.112'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.12', 'Италийские языки (мёртвые)',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.13', 'Романские языки',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.14', 'Греческий',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.16', 'Славянские языки',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.17', 'Балтийские языки',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.18', 'Албанский язык',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.19', 'Армянский язык',
        (SELECT id FROM category WHERE code = '811.1/.8'));
INSERT INTO category (code, name, parent_id)
VALUES ('811.9', 'Искусственные языки',
        (SELECT id FROM category WHERE code = '811'));
INSERT INTO category (code, name, parent_id)
VALUES ('82', 'Литература. Литературоведение',
        (SELECT id FROM category WHERE code = '8'));
INSERT INTO category (code, name, parent_id)
VALUES ('821', 'Художественная литература на отдельных языках',
        (SELECT id FROM category WHERE code = '82'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.1/.2', 'Литературы на индоевропейских языках',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.11', 'Литература на германских языках',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.111', 'Художественная литература на английском языке',
        (SELECT id FROM category WHERE code = '821.11'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.112', 'Литература на германских языках (кроме английского)',
        (SELECT id FROM category WHERE code = '821.11'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.113', 'Художественная литература на северогерманских языках',
        (SELECT id FROM category WHERE code = '821.11'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.12', 'Литература италийских языков',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.13', 'Литература на норманских языках',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.14', 'Греческая литература',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.16', 'Художественная литература на славянских языках',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.17', 'Художественная литература на балтийских языках',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.18', 'Албанская литература',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.19', 'Армянская художественная литература',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.21/.22', 'Художественная литература на индоиранских языках',
        (SELECT id FROM category WHERE code = '821.1/.2'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.3', 'Литература кавказских языков. Литературы на мёртвых языках неизвестного происхождения',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.4', 'Литература афро-азиатских, нило-сахарских, конго-кордофанских, койсанских языков',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.5',
        'Литература урало-алтайских, палеосибирских, алеутско-эскимосских, дравидских, сино-тибетских языков. Литература японского, корейского, айнского языков',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.6', 'Литература аустроазиатских языков. Австронезийские литературы',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.7', 'Литература индо-тихоокеанских (неавстронезийских) языков. Австралийская аборигенная литература',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.8', 'Литература исконных языков Америки (Америндская литература)',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('821.9', 'Художественная литература на искусственных языках',
        (SELECT id FROM category WHERE code = '821'));
INSERT INTO category (code, name, parent_id)
VALUES ('9', 'География. Биографии. История',
        null);
INSERT INTO category (code, name, parent_id)
VALUES ('90', null,
        (SELECT id FROM category WHERE code = '9'));
INSERT INTO category (code, name, parent_id)
VALUES ('900', null,
        (SELECT id FROM category WHERE code = '90'));
INSERT INTO category (code, name, parent_id)
VALUES ('901', null,
        (SELECT id FROM category WHERE code = '90'));

INSERT INTO category (code, name, parent_id)
VALUES ('902', 'Археология',
        (SELECT id FROM category WHERE code = '90'));

INSERT INTO category (code, name, parent_id)
VALUES ('903', 'Предыстория. Доисторические остатки, орудия труда, древности',
        (SELECT id FROM category WHERE code = '90'));
INSERT INTO category (code, name, parent_id)
VALUES ('91', 'География. Географические исследования Земли и отдельных стран. Путешествия. Региональная география',
        (SELECT id FROM category WHERE code = '9'));
INSERT INTO category (code, name, parent_id)
VALUES ('92', null,
        (SELECT id FROM category WHERE code = '9'));

INSERT INTO category (code, name, parent_id)
VALUES ('929', 'Биографические и подобные исследования',
        (SELECT id FROM category WHERE code = '92'));

INSERT INTO category (code, name, parent_id)
VALUES ('929.5', 'Генеалогия',
        (SELECT id FROM category WHERE code = '929'));
INSERT INTO category (code, name, parent_id)
VALUES ('929.6', 'Геральдика. Гербы. Девизы. Эмблемы',
        (SELECT id FROM category WHERE code = '929'));
INSERT INTO category (code, name, parent_id)
VALUES ('929.7', 'Нобилитет. Знатность. Дворянство. Титулы знатности',
        (SELECT id FROM category WHERE code = '929'));
INSERT INTO category (code, name, parent_id)
VALUES ('929.9', 'Флаги. Штандарты. Знамёна',
        (SELECT id FROM category WHERE code = '929'));
INSERT INTO category (code, name, parent_id)
VALUES ('93', null,
        (SELECT id FROM category WHERE code = '9'));

INSERT INTO category (code, name, parent_id)
VALUES ('930', 'Историческая наука. Историография',
        (SELECT id FROM category WHERE code = '9'));

INSERT INTO category (code, name, parent_id)
VALUES ('94', 'Всеобщая история',
        (SELECT id FROM category WHERE code = '0'));
