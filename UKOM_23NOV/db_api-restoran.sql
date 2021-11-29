-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2021 at 09:06 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apirestoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `iddetail` int(10) UNSIGNED NOT NULL,
  `idorder` int(11) NOT NULL,
  `idmenu` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `hargajual` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`iddetail`, `idorder`, `idmenu`, `jumlah`, `hargajual`, `created_at`, `updated_at`) VALUES
(1, 1, 9, 1, 20000, '2021-03-22 00:37:37', '2021-03-22 00:37:37'),
(2, 1, 11, 2, 25000, '2021-03-22 00:37:37', '2021-03-22 00:37:37'),
(3, 4, 13, 2, 3000, NULL, NULL),
(4, 4, 14, 3, 200, NULL, NULL),
(5, 4, 15, 4, 200, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kategoris`
--

CREATE TABLE `kategoris` (
  `idkategori` int(10) UNSIGNED NOT NULL,
  `kategori` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `keterangan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kategoris`
--

INSERT INTO `kategoris` (`idkategori`, `kategori`, `keterangan`, `created_at`, `updated_at`) VALUES
(1, 'Makanan Berat', 'keterangan yoi', '2021-02-09 02:56:10', '2021-03-01 04:56:37'),
(2, 'Makanan Ringan', 'Non laboriosam eos aut animi ducimus ad alias. Odio vitae natus aut facere. Delectus hic vel voluptatem nesciunt laudantium rerum excepturi. Omnis rerum sint ut repellendus quod.', '2021-02-09 03:03:30', '2021-02-09 03:03:30'),
(3, 'Minuman', 'Omnis tempora explicabo inventore molestiae dolore. At alias facilis iure. Unde iure deleniti fugiat deleniti optio libero. Dicta modi minima possimus deserunt corrupti omnis consequuntur.', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(4, 'Herbal', 'Pariatur illum reprehenderit nemo dolorem temporibus minima eum. Commodi officiis vero veniam eaque aliquid qui vel.', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(5, 'Lainnya', 'Cupiditate necessitatibus et nihil aut quasi cum qui. Fuga beatae hic assumenda in quas aut quaerat. Libero provident quia ipsam nulla.', '2021-02-09 03:05:20', '2021-02-09 03:05:20');

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE `menus` (
  `idmenu` int(10) UNSIGNED NOT NULL,
  `idkategori` int(255) NOT NULL,
  `idtoko` int(11) NOT NULL,
  `kategori` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `produk` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kodeproduk` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stok` int(11) NOT NULL,
  `deskripsi` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gambar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `harga` bigint(20) NOT NULL,
  `namatoko` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fototoko` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tahunusaha` int(11) NOT NULL,
  `alamattoko` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kecamatan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kabupaten` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sosmed` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `whatsapp` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `menu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`idmenu`, `idkategori`, `idtoko`, `kategori`, `produk`, `kodeproduk`, `stok`, `deskripsi`, `gambar`, `harga`, `namatoko`, `fototoko`, `tahunusaha`, `alamattoko`, `kecamatan`, `kabupaten`, `sosmed`, `whatsapp`, `email`, `menu`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'Makanan Berat', 'Nasi Uduk', 'nasduk123', 10, 'Nasi uduk merupakan kreasi nasi putih yang sudah diberi bumbu sehingga menghasilkan cita rasa yang gurih.\r\n\r\nLauk pauk terdiri dari tahu bumbu kare, tempe orek, telor bali / telor dadar, bihun, topping bawang goreng dan krupuk. \r\n', 'http://192.168.0.157:8000/upload/nasi_uduk.jpeg', 8000, 'Kedai Nyak Babe', 'http://192.168.0.157:8000/upload/nyakbabe.jpg', 2018, 'Taman Candiloka A2/09, Ngampelsari, Candi, Sidoarjo', 'Candi', 'Sidoarjo', 'IG : @kedai_nyakbabe\r\nFB : nyakbabe123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 01:32:16', '2021-03-08 06:52:05'),
(2, 1, 2, 'Makanan Berat', 'Nasi Goreng', 'nasgor123', 20, 'Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk.', 'http://192.168.0.157:8000/upload/nasi_goreng.jpg', 12000, 'Warung Barokah', 'http://192.168.0.157:8000/upload/barokah.jpg', 2015, 'Permata Porong Permai XX/33 Candipari, Porong, Sidoarjo', 'Porong', 'Sidoarjo', 'IG : @warungbarokah\r\nFB : warungbarokah123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 04:12:07', '2021-03-08 04:12:07'),
(3, 1, 3, 'Makanan Berat', 'Sate Ayam', 'satyam123', 16, 'Sate ayam adalah makanan khas Indonesia. Sate Ayam dibuat dari daging ayam. Pada umumnya sate ayam dimasak dengan cara dipanggang dengan menggunakan arang dan disajikan dengan pilihan bumbu kacang atau bumbu kecap.', 'http://192.168.0.157:8000/upload/sate_ayam.jpeg', 20000, 'Warung Merah', 'http://192.168.0.157:8000/upload/merah.jpg', 2020, 'Gempolsari Rt.07 Rw.05 Tanggulangin, Sidoarjo', 'Tanggulangin', 'Sidoarjo', 'IG : @warungmerah_\r\nFB : warungmerah123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 05:42:05', '2021-03-08 05:42:05'),
(4, 2, 1, 'Makanan Ringan', 'Keripik Tempe', 'krpktmp123', 55, 'Keripik tempe adalah makanan tradisional sejenis keripik yang tentunya terbuat dari tempe. Berbeda dengan jenis keripik pada umumnya yang banyak dibuat dari singkong atau kentang, keripik tempe dibuat dari bahan dasar tempe kedelai.', 'http://192.168.0.157:8000/upload/keripik_tempe.jpeg', 7000, 'Kedai Nyak Babe', 'http://192.168.0.157:8000/upload/nyakbabe.jpg', 2018, 'Taman Candiloka A2/09, Ngampelsari, Candi, Sidoarjo', 'Candi', 'Sidoarjo', 'IG : @kedai_nyakbabe\nFB : nyakbabe123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 05:42:05', '2021-03-08 05:42:05'),
(5, 3, 2, 'Minuman', 'Sinom', 'snm123', 17, 'Jamu sinom ini sangat bagus digunakan sebagai minuman penyegar saat cuaca panas atau pun sekadar penghilang haus. Minuman dari asam jawa ini bisa digunakan untuk melancarkan peredaran darah, mengurangi nyeri saat haid, melangsingkan tubuh, dll.', 'http://192.168.0.157:8000/upload/sinom.jpeg', 6000, 'Warung Barokah', 'http://192.168.0.157:8000/upload/barokah.jpg', 2015, 'Permata Porong Permai XX/33 Candipari, Porong, Sidoarjo', 'Porong', 'Sidoarjo', 'IG : @warungbarokah\r\nFB : warungbarokah123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 04:12:07', '2021-03-08 04:12:07'),
(6, 4, 3, 'Herbal', 'Jahe Merah Instan', 'jamerins123', 70, 'Manfaat Jahe Merah Instan:\r\nUntuk membantu menurunkan berat badan\r\nMenjaga kondisi jantung\r\nMenangkal mabuk di perjalanan\r\nMeningkatkan sistem kekebalan tubuh', 'http://192.168.0.157:8000/upload/jahe_merah_instan.jpeg', 15000, 'Warung Merah', 'http://192.168.0.157:8000/upload/merah.jpg', 2020, 'Gempolsari Rt.07 Rw.05 Tanggulangin, Sidoarjo', 'Tanggulangin', 'Sidoarjo', 'IG : @warungmerah_\r\nFB : warungmerah123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 05:42:05', '2021-03-08 05:42:05'),
(7, 5, 3, 'Lainnya', 'Sambal Bawang', 'smblbwng123', 28, 'Sambal adalah saus pedas dengan bahan utama yang disiapkan dari cabai yang dilumatkan sehingga keluar kandungan sari cabe dan ditambah bahan-bahan lain seperti garam dan terasi. Bagi sebagian orang, menyantap makanan tanpa kehadiran sambal tentu tak nikmat. Memang sambal merupakan magnet lidah. Sajikan Sambal Bawang ini untuk teman santap siang keluarga anda.', 'http://192.168.0.157:8000/upload/sambal_bawang.jpeg', 18000, 'Warung Merah', 'http://192.168.0.157:8000/upload/merah.jpg', 2020, 'Gempolsari Rt.07 Rw.05 Tanggulangin, Sidoarjo', 'Tanggulangin', 'Sidoarjo', 'IG : @warungmerah_\r\nFB : warungmerah123', '083102611131', 'suhailahnfsella@gmail.com', '0', '2021-03-08 05:42:05', '2021-03-08 05:42:05');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(5, '2021_02_09_014849_create_kategoris_table', 1),
(6, '2021_02_09_023111_create_pelanggans_table', 1),
(7, '2021_02_15_055748_create_menus_table', 2),
(8, '2021_02_18_015538_user', 3),
(9, '2021_03_15_001518_create_orders_table', 4),
(10, '2021_03_15_001720_create_details_table', 4),
(11, '2021_11_18_071826_add_produk_to_menus_table', 5),
(12, '2021_11_18_074915_add_kategori_to_menus_table', 6),
(13, '2021_11_18_084009_add_kecamatan_to_menus_table', 7),
(14, '2021_11_18_084134_add_kabupaten_to_menus_table', 7),
(15, '2021_11_18_084422_add_namatoko_to_menus_table', 8),
(16, '2021_11_18_084820_add_stok_to_menus_table', 8),
(17, '2021_11_18_084846_add_fototoko_to_menus_table', 8),
(18, '2021_11_18_085713_add_tahunusaha_to_menus_table', 8),
(19, '2021_11_18_085730_add_alamattoko_to_menus_table', 8),
(20, '2021_11_18_085745_add_sosmed_to_menus_table', 8),
(21, '2021_11_18_094322_add_idkateggori_to_menus_table', 9),
(22, '2021_11_18_095323_add_idtoko_to_menus_table', 10),
(23, '2021_11_18_100913_add_menu_to_menus_table', 11),
(24, '2021_11_18_101542_add_deskripsi_to_menus_table', 12),
(25, '2021_11_20_054534_add_whatsapp_to_menus_table', 13),
(26, '2021_11_20_054736_add_email_to_menus_table', 14),
(27, '2021_11_20_062723_add_kodeproduk_to_menus_table', 15),
(28, '2021_11_21_053414_add_username_to_users_table', 16),
(29, '2021_11_21_053553_add_namapanjang_to_users_table', 16),
(30, '2021_11_21_072311_add_idtoko_to_users_table', 17),
(31, '2021_11_21_092505_add_idtoko_to_users_table', 18),
(32, '2021_11_22_114209_add_fototoko_to_users_table', 19),
(33, '2021_11_22_114322_add_fotoprofil_to_users_table', 19),
(34, '2021_11_23_025556_add_email_to_users_table', 20),
(35, '2021_11_28_004841_add_telp_to_users_table', 21);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `idorder` int(10) UNSIGNED NOT NULL,
  `idpelanggan` int(11) NOT NULL,
  `tglorder` date NOT NULL,
  `total` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`idorder`, `idpelanggan`, `tglorder`, `total`, `bayar`, `kembali`, `status`, `created_at`, `updated_at`) VALUES
(1, 1, '2021-03-15', 20000, 6000, 3000, 1, NULL, '2021-03-15 00:37:08'),
(2, 2, '2021-03-15', 40000, 45000, 5000, 1, NULL, '2021-03-15 03:05:50'),
(3, 3, '2021-03-10', 20000, 0, 0, 0, NULL, NULL),
(4, 5, '2021-03-22', 20000, 0, 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggans`
--

CREATE TABLE `pelanggans` (
  `idpelanggan` int(10) UNSIGNED NOT NULL,
  `pelanggan` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pelanggans`
--

INSERT INTO `pelanggans` (`idpelanggan`, `pelanggan`, `alamat`, `telp`, `created_at`, `updated_at`) VALUES
(1, 'tes kategori', 'keterangan', '123', '2021-02-09 02:56:10', '2021-02-15 05:35:58'),
(2, 'Deja Ratke', '72087 Viva Hills Suite 281\nKarsonshire, CA 62603', '1-472-961-4809', '2021-02-09 03:03:30', '2021-02-09 03:03:30'),
(3, 'Hailey Roob', '52025 Klocko Drive Apt. 407\nWest Rosa, NY 15172', '956.248.6966', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(4, 'Tania Lynch', '58464 Elliot Mountains Apt. 718\nVidaside, IL 17372-4068', '+15257388371', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(5, 'Prof. Bart Gibson PhD', '95807 Goyette Land\nWeimannville, MT 01727', '386.752.8506', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(6, 'Austen DuBuque', '9900 Roberto Circles Apt. 910\nPort Raoulland, NV 24640', '+17418205666', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(7, 'Donnie Batz', '17151 Princess Expressway Apt. 643\nPort Florenceshire, MD 36963-6091', '+16348003420', '2021-02-09 03:05:20', '2021-02-09 03:05:20'),
(8, 'Darius Skiles', '8615 Runolfsdottir Prairie\nAbbottshire, MT 25786-3526', '626-221-2742', '2021-02-09 03:05:20', '2021-02-09 03:05:20');

-- --------------------------------------------------------

--
-- Table structure for table `tokos`
--

CREATE TABLE `tokos` (
  `id` int(11) NOT NULL,
  `idtoko` int(11) NOT NULL,
  `namatoko` varchar(225) NOT NULL,
  `fototoko` varchar(225) NOT NULL,
  `alamattoko` varchar(225) NOT NULL,
  `kecamatan` varchar(225) NOT NULL,
  `kabupaten` varchar(225) NOT NULL,
  `tahuntoko` int(11) NOT NULL,
  `sosmed` varchar(225) NOT NULL,
  `whatsapp` varchar(225) NOT NULL,
  `email` varchar(225) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tokos`
--

INSERT INTO `tokos` (`id`, `idtoko`, `namatoko`, `fototoko`, `alamattoko`, `kecamatan`, `kabupaten`, `tahuntoko`, `sosmed`, `whatsapp`, `email`, `created_at`, `updated_at`) VALUES
(4, 1, 'Kedai Luar Biasa', 'http://192.168.3.74:8000/upload/kedaibiasa.jpg', 'Jl Palem 7 Rt.05 Rw.04', 'Candi', 'Sidoarjo', 2019, 'IG : @kedaibiasa\nFB : kedaibiasa123', '083102611131', 'kedaibiasa@gmail.com', '2021-11-23 01:46:59', '2021-11-23 01:46:59');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `idtoko` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namapanjang` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fotoprofil` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `level` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `api_token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `fototoko` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `idtoko`, `username`, `email`, `telp`, `namapanjang`, `fotoprofil`, `password`, `level`, `api_token`, `status`, `fototoko`, `created_at`, `updated_at`) VALUES
(12, 1, 'suhailahnfsella_', '', '0', 'Suhailah Nuriyah Fahma', 'http://192.168.0.157:8000/upload/ff.png', 'sella123', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-21 09:51:15', '2021-11-21 09:51:15'),
(14, 0, 'vierra_vi', '', '0', 'Vierra Vikanda', 'http://192.168.0.157:8000/upload/ff.png', 'vivi123', 'pelanggan', '123456', 1, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-21 10:14:25', '2021-11-21 10:14:25'),
(15, 0, 'nafisa123', '', '0', 'Nafisa Annisa ', 'http://192.168.0.157:8000/upload/ff.png', 'nafnaf', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-21 10:19:11', '2021-11-21 10:19:11'),
(16, 0, 'anindyaput22', '', '0', 'Anindya Putri', 'http://192.168.0.157:8000/upload/ff.png', 'nindya22', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-21 10:54:02', '2021-11-21 10:54:02'),
(20, 0, 'y', '', '0', 'y', 'http://192.168.0.157:8000/upload/ff.png', 'y', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-22 02:30:09', '2021-11-22 02:30:09'),
(36, 0, 'coba', 'coba@gmail.com', '0', 'coba', 'http://192.168.0.157:8000/upload/ff.png', 'cobacoba', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-28 00:20:52', '2021-11-28 00:20:52'),
(43, 0, 'sella12345', 'sella@gmail.com', '083132091676', 'Suhailah Nuriyah Fahma', 'http://192.168.0.157:8000/upload/ff.png', 'Sella1111', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-28 02:28:19', '2021-11-28 02:28:19'),
(44, 0, 'tes', 'tes@gmail.com', '083102611131', 'tes', 'http://192.168.0.157:8000/upload/ff.png', 'testes123', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-28 03:17:04', '2021-11-28 03:17:04'),
(45, 0, 'sella25', 'sella25@gmail.com', '83102611131', 'Suhailah', 'http://192.168.0.157:8000/upload/ff.png', 'sella123', 'pelanggan', '123456', 0, 'http://192.168.0.157:8000/upload/ff.png', '2021-11-29 00:56:51', '2021-11-29 00:56:51');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`iddetail`);

--
-- Indexes for table `kategoris`
--
ALTER TABLE `kategoris`
  ADD PRIMARY KEY (`idkategori`);

--
-- Indexes for table `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`idmenu`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`idorder`);

--
-- Indexes for table `pelanggans`
--
ALTER TABLE `pelanggans`
  ADD PRIMARY KEY (`idpelanggan`);

--
-- Indexes for table `tokos`
--
ALTER TABLE `tokos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `iddetail` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kategoris`
--
ALTER TABLE `kategoris`
  MODIFY `idkategori` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `menus`
--
ALTER TABLE `menus`
  MODIFY `idmenu` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `idorder` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pelanggans`
--
ALTER TABLE `pelanggans`
  MODIFY `idpelanggan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tokos`
--
ALTER TABLE `tokos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
