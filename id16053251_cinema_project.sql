-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Июн 01 2021 г., 13:01
-- Версия сервера: 10.3.16-MariaDB
-- Версия PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `id16053251_cinema_project`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Comment`
--

CREATE TABLE `Comment` (
  `comment_id` bigint(20) NOT NULL,
  `receiver_id` bigint(20) DEFAULT NULL,
  `sender_id` bigint(20) NOT NULL,
  `discussion_id` bigint(20) NOT NULL,
  `text` longtext COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Discussion`
--

CREATE TABLE `Discussion` (
  `discussion_id` bigint(20) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `film_id` bigint(20) DEFAULT NULL,
  `creation_date` date NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Films_list`
--

CREATE TABLE `Films_list` (
  `films_list_id` bigint(20) NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Films_list_Film`
--

CREATE TABLE `Films_list_Film` (
  `id` bigint(20) NOT NULL,
  `films_list_id` bigint(20) NOT NULL,
  `film_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Friends`
--

CREATE TABLE `Friends` (
  `friends_id` int(11) NOT NULL,
  `type` int(11) DEFAULT 0,
  `request_user_id` bigint(20) NOT NULL,
  `approved_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `Friends`
--

INSERT INTO `Friends` (`friends_id`, `type`, `request_user_id`, `approved_user_id`) VALUES
(7, 1, 17, 13),
(8, 1, 18, 17);

-- --------------------------------------------------------

--
-- Структура таблицы `Interest`
--

CREATE TABLE `Interest` (
  `interest_id` bigint(20) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Interest_User`
--

CREATE TABLE `Interest_User` (
  `interest_user_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `interest_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Likes`
--

CREATE TABLE `Likes` (
  `like_id` bigint(20) NOT NULL,
  `entity_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `Message`
--

CREATE TABLE `Message` (
  `message_id` bigint(20) NOT NULL,
  `receiver_id` bigint(20) NOT NULL,
  `sender_id` bigint(20) NOT NULL,
  `message` longtext COLLATE utf8_unicode_ci NOT NULL,
  `message_date` bigint(20) NOT NULL,
  `deleted_by_sender_id` tinyint(4) DEFAULT 0,
  `deleted_by_receiver_id` tinyint(4) DEFAULT 0,
  `message_type_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `Message`
--

INSERT INTO `Message` (`message_id`, `receiver_id`, `sender_id`, `message`, `message_date`, `deleted_by_sender_id`, `deleted_by_receiver_id`, `message_type_id`) VALUES
(5, 13, 17, 'hello', 1622490829292, 0, 0, 1),
(6, 13, 17, 'hh', 1622491364072, 0, 0, 1),
(7, 13, 17, 'dd', 1622491435390, 1, 0, 1),
(8, 13, 17, 'hi', 1622491994167, 1, 0, 1),
(9, 13, 17, 'hh', 1622492569464, 1, 0, 1),
(10, 13, 17, 'hh', 1622492580487, 1, 0, 1),
(11, 13, 17, '../uploadsMessages/user_17_1622494770924_photo', 1622494770924, 1, 0, 2),
(12, 13, 17, 'ggg', 1622534928978, 1, 0, 1),
(13, 13, 17, 'ggg', 1622537488947, 1, 0, 1),
(14, 13, 17, '../uploadsMessages/user_17_1622537520869_photo', 1622537520869, 1, 0, 2),
(15, 13, 17, 'ff', 1622548009076, 1, 0, 1),
(16, 13, 17, '../uploadsMessages/user_17_1622548030560_photo', 1622548030560, 1, 0, 2),
(17, 13, 17, '../uploadsMessages/user_17_1622548631620_photo', 1622548631620, 0, 0, 2),
(18, 17, 13, 'fff', 1622551686641, 0, 0, 1),
(19, 13, 17, 'jfjjf', 1622551701966, 0, 0, 1),
(20, 17, 13, 'ttt', 1622551728347, 0, 0, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `Message_type`
--

CREATE TABLE `Message_type` (
  `message_type_id` bigint(20) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `Message_type`
--

INSERT INTO `Message_type` (`message_type_id`, `name`) VALUES
(1, 'normal_text'),
(2, 'image_text');

-- --------------------------------------------------------

--
-- Структура таблицы `User`
--

CREATE TABLE `User` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `surname` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `token` text COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `about` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_date` bigint(20) NOT NULL,
  `last_seen` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `User`
--

INSERT INTO `User` (`user_id`, `email`, `name`, `surname`, `password`, `token`, `birthday`, `image`, `city`, `about`, `user_date`, `last_seen`) VALUES
(13, 'miftakhovaalbina@gmail.com', 'Альбина', 'Мифтахова', 'Pnz68QF/OARoHScq/pWT0w==', '', '1999-06-21', '../uploadsProfiles/user_13_1619807295750_photo', 'Казань', NULL, 1618703682431, 1622551672367),
(17, 'belypled@yandex.ru', 'alya', 'mift', 'W0wmS08HsKBpQPJGxNdWjA==', '12345', '1990-01-01', 'dfbdfb', 'moscow', NULL, 1619377978456, 1622551748083),
(18, 'qq@qq.ru', 'qq', 'qq', 't5zzJ/rXN6UWWAl4IimjMA==', '12345', '2000-01-01', '000', 'qq', NULL, 1621669772203, 1621669774509);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Comment`
--
ALTER TABLE `Comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `fk_Comment_User1` (`sender_id`),
  ADD KEY `fk_Comment_User2` (`receiver_id`),
  ADD KEY `fk_Comment_Discussion1` (`discussion_id`);

--
-- Индексы таблицы `Discussion`
--
ALTER TABLE `Discussion`
  ADD PRIMARY KEY (`discussion_id`);

--
-- Индексы таблицы `Films_list`
--
ALTER TABLE `Films_list`
  ADD PRIMARY KEY (`films_list_id`),
  ADD KEY `fk_Films_list_User1` (`user_id`);

--
-- Индексы таблицы `Films_list_Film`
--
ALTER TABLE `Films_list_Film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Films_list_Film_Films_list1` (`films_list_id`);

--
-- Индексы таблицы `Friends`
--
ALTER TABLE `Friends`
  ADD PRIMARY KEY (`friends_id`),
  ADD KEY `fk_Friends_User1` (`approved_user_id`),
  ADD KEY `fk_Friends_User2` (`request_user_id`);

--
-- Индексы таблицы `Interest`
--
ALTER TABLE `Interest`
  ADD PRIMARY KEY (`interest_id`);

--
-- Индексы таблицы `Interest_User`
--
ALTER TABLE `Interest_User`
  ADD PRIMARY KEY (`interest_user_id`),
  ADD KEY `fk_Interest_User_user` (`user_id`),
  ADD KEY `fk_Interest_User_Interest1` (`interest_id`);

--
-- Индексы таблицы `Likes`
--
ALTER TABLE `Likes`
  ADD PRIMARY KEY (`like_id`),
  ADD KEY `fk_Likes_User1` (`user_id`),
  ADD KEY `fk_Likes_Comment1` (`entity_id`);

--
-- Индексы таблицы `Message`
--
ALTER TABLE `Message`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `fk_Message_User1` (`sender_id`),
  ADD KEY `fk_Message_User2` (`receiver_id`),
  ADD KEY `fk_Message_Message_type1` (`message_type_id`);

--
-- Индексы таблицы `Message_type`
--
ALTER TABLE `Message_type`
  ADD PRIMARY KEY (`message_type_id`);

--
-- Индексы таблицы `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Comment`
--
ALTER TABLE `Comment`
  MODIFY `comment_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Discussion`
--
ALTER TABLE `Discussion`
  MODIFY `discussion_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Films_list`
--
ALTER TABLE `Films_list`
  MODIFY `films_list_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Films_list_Film`
--
ALTER TABLE `Films_list_Film`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Friends`
--
ALTER TABLE `Friends`
  MODIFY `friends_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `Interest`
--
ALTER TABLE `Interest`
  MODIFY `interest_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Interest_User`
--
ALTER TABLE `Interest_User`
  MODIFY `interest_user_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Likes`
--
ALTER TABLE `Likes`
  MODIFY `like_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Message`
--
ALTER TABLE `Message`
  MODIFY `message_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT для таблицы `Message_type`
--
ALTER TABLE `Message_type`
  MODIFY `message_type_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `User`
--
ALTER TABLE `User`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Comment`
--
ALTER TABLE `Comment`
  ADD CONSTRAINT `fk_Comment_Discussion1` FOREIGN KEY (`discussion_id`) REFERENCES `Discussion` (`discussion_id`),
  ADD CONSTRAINT `fk_Comment_User1` FOREIGN KEY (`sender_id`) REFERENCES `User` (`user_id`),
  ADD CONSTRAINT `fk_Comment_User2` FOREIGN KEY (`receiver_id`) REFERENCES `User` (`user_id`);

--
-- Ограничения внешнего ключа таблицы `Films_list`
--
ALTER TABLE `Films_list`
  ADD CONSTRAINT `fk_Films_list_User1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`);

--
-- Ограничения внешнего ключа таблицы `Films_list_Film`
--
ALTER TABLE `Films_list_Film`
  ADD CONSTRAINT `fk_Films_list_Film_Films_list1` FOREIGN KEY (`films_list_id`) REFERENCES `Films_list` (`films_list_id`);

--
-- Ограничения внешнего ключа таблицы `Friends`
--
ALTER TABLE `Friends`
  ADD CONSTRAINT `fk_Friends_User1` FOREIGN KEY (`approved_user_id`) REFERENCES `User` (`user_id`),
  ADD CONSTRAINT `fk_Friends_User2` FOREIGN KEY (`request_user_id`) REFERENCES `User` (`user_id`);

--
-- Ограничения внешнего ключа таблицы `Interest_User`
--
ALTER TABLE `Interest_User`
  ADD CONSTRAINT `fk_Interest_User_Interest1` FOREIGN KEY (`interest_id`) REFERENCES `Interest` (`interest_id`),
  ADD CONSTRAINT `fk_Interest_User_user` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`);

--
-- Ограничения внешнего ключа таблицы `Likes`
--
ALTER TABLE `Likes`
  ADD CONSTRAINT `fk_Likes_Comment1` FOREIGN KEY (`entity_id`) REFERENCES `Comment` (`comment_id`),
  ADD CONSTRAINT `fk_Likes_Films_list1` FOREIGN KEY (`entity_id`) REFERENCES `Films_list` (`films_list_id`),
  ADD CONSTRAINT `fk_Likes_User1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`);

--
-- Ограничения внешнего ключа таблицы `Message`
--
ALTER TABLE `Message`
  ADD CONSTRAINT `fk_Message_Message_type1` FOREIGN KEY (`message_type_id`) REFERENCES `Message_type` (`message_type_id`),
  ADD CONSTRAINT `fk_Message_User1` FOREIGN KEY (`sender_id`) REFERENCES `User` (`user_id`),
  ADD CONSTRAINT `fk_Message_User2` FOREIGN KEY (`receiver_id`) REFERENCES `User` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
