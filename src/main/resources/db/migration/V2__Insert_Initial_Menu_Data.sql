DELETE FROM menus;

INSERT INTO menus (id, name, description, image_url, price, is_main_menu, is_active, is_deleted)
VALUES
-- Main Menu
('d7b5b3f0-1b7e-4c3e-9c1e-5a0a3a7f8b9c', 'Nasi Ayam Cabe Garam', 'Terdapat nasi dan potongan daging ayam popcorn + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_cabe_garam_r35sox.jpg', 15000, TRUE, TRUE, FALSE),
('a8c6d4e1-2c8f-4d4f-8d2f-6b1b4b8f9d0d', 'Nasi Ayam Lada Hitam', 'Terdapat nasi dan potongan daging ayam dan dibumbui khas + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_ayam_lada_hitam_j3ddau.jpg', 15000, TRUE, TRUE, FALSE),
('b9d7e5f2-3d9g-5e5g-9e3g-7c2c5c9g0e1e', 'Nasi Goreng Telor', 'Nasi khas Dapur Hi dengan bumbu rahasia + Telor + Tahu/Tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_goreng_telor_oruyur.jpg', 13000, TRUE, TRUE, FALSE),
('c0e8f6g3-4e0h-6f6h-0f4h-8d3d6d0h1f2f', 'Nasi Ayam Geprek', 'Terdapat nasi dan ayam geprek dengan sambel khas DapurHi + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_ayam_geprek_yqwa5x.jpg', 15000, TRUE, TRUE, FALSE),
('e1f9g7h4-5f1i-7g7i-1g5i-9e4e7e1i2g3g', 'Nasi Ayam Cabe Ijo', 'Terdapat nasi dan ayam dengan sambel khas DapurHi + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_ayam_cabe_ijo_exszrj.jpg', 15000, TRUE, TRUE, FALSE),
('f2g0h8i5-6g2j-8h8j-2h6j-0f5f8f2j3h4h', 'Nasi Sup Ayam', 'Terdapat nasi dan sop ayam (Potongan Ayam-Kentang-Wortel) + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_sop_ayam_r0hpxp.jpg', 15000, TRUE, TRUE, FALSE),
('g3h1i9j6-7h3k-9i9k-3i7k-1g6g9g3k4i5i', 'Nasi Ayam Bakar', 'Terdapat nasi dan Ayam Balar khas DapurHi + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_ayam_bakar_hyakgj.jpg', 15000, TRUE, TRUE, FALSE),
('h4i2j0k7-8i4l-0j0l-4j8l-2h7h0h4l5j6j', 'Mie Goreng Ayam Geprek', 'Mie goreng khas dapur hi dan ayam geprek + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/mie_goreng_ayam_geprek_zrfzkt.jpg', 15000, TRUE, TRUE, FALSE),
('i5j3k1l8-9j5m-1k1m-5k9m-3i8i1i5m6k7k', 'Nasi Goreng Nugget', 'Nasi goreng khas Dapur hi dengan topinh nuaget + tahu/tempe.', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_goreng_tahu_nugget_ktybpq.jpg', 15000, TRUE, TRUE, FALSE),
('j6k4l2m9-0k6n-2l2n-6l0n-4j9j2j6n7l8l', 'Nasi Telur Barendo', 'Terdapat nasi dengan telor dadar kriuk khas DapurHi + tahu/tempe (Tidak dengan sayur yaa).', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_telur_barendo_apuleg.jpg', 13000, TRUE, TRUE, FALSE),
('k7l5m3n0-1l7o-3m3o-7m1o-5k0k3k7o8m9m', 'Nasi Goreng Ayam Bakar', 'Terdapat nasi goreng khas dapur hi dengan ayam bakar + tahu/tempe', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_goreng_ayam_bakar_mj73pk.jpg', 17000, TRUE, TRUE, FALSE),
('l8m6n4o1-2m8p-4n4p-8n2p-6l1l4l8p9n0n', 'Nasi Goreng', 'Mie kuah khas DapurHi dengan toping telor + tahu/tempe', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nasi_goreng_t14zuq.jpg', 13000, TRUE, TRUE, FALSE),

-- Side Menu & Drinks
('m9n7o5p2-3n9q-5o5q-9o3q-7m2m5m9q0o1o', 'Aqua Gelas', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/aqua_gelas_ccarrz.jpg', 1000, FALSE, TRUE, FALSE),
('n0o8p6q3-4o0r-6p6r-0p4r-8n3n6n0r1p2p', 'Le Minerale', 'Ukuran 650ml', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/Le_Mineral_olfoj6.jpg', 5000, FALSE, TRUE, FALSE),
('o1p9q7r4-5p1s-7q7s-1q5s-9o4o7o1s2q3q', 'Nasi Putih', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/Nasi_Putih_ymwzl8.jpg', 5000, FALSE, TRUE, FALSE),
('p2q0r8s5-6q2t-8r8t-2r6t-0p5p8p2t3r4r', 'Telur Dadar', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/Telor_Dadar_djej0i.jpg', 5000, FALSE, TRUE, FALSE),
('q3r1s9t6-7r3u-9s9u-3s7u-1q6q9q3u4s5s', 'Telur Ceplok', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/Telor_Ceplok_ciaquh.jpg', 5000, FALSE, TRUE, FALSE),
('r4s2t0u7-8s4v-0t0v-4t8v-2r7r0r4v5t6t', 'Orek Tempe', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/orek_tempe_yl6xoa.jpg', 5000, FALSE, TRUE, FALSE),
('s5t3u1v8-9t5w-1u1w-5u9w-3s8s1s5w6u7u', 'Bakwan Kol', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/bakwan_kol_txrcfr.jpg', 2000, FALSE, TRUE, FALSE),
('t6u4v2w9-0u6x-2v2x-6v0x-4t9t2t6x7v8v', 'Nugget Goreng', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/nugget_goreng_etrj3f.jpg', 8000, FALSE, TRUE, FALSE),
('u7v5w3x0-1v7y-3w3y-7w1y-5u0u3u7y8w9w', 'Cireng Tahu', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/cireng_tahu_qzuuzk.jpg', 10000, FALSE, TRUE, FALSE),
('v8w6x4y1-2w8z-4x4z-8x2z-6v1v4v8z9x0x', 'French Fries', NULL, 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/kentang_krispy_apxqox.jpg', 5000, FALSE, TRUE, FALSE),
('w9x7y5z2-3x9a-5y5a-9y3a-7w2w5w9a0y1y', 'Es Teh Manis', ' Es teh cekik ( tidak pake cup atau gelas yaa).', 'https://res.cloudinary.com/dh8gmlzth/image/upload/w_auto,f_auto/esteh_wyc6db.jpg', 3000, FALSE, TRUE, FALSE);
