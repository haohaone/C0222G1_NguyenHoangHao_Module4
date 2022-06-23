USE `07_spring_boot`;

INSERT INTO blog_detail(content) VALUE
("Duy Trung Ngu"),
("Anh Hảo Nè"),
("Hảo Đẹp Trai"),
("Hảo Đẹp Trai"),
("Hảo Đẹp Trai"),
("Hảo Đẹp Trai");

INSERT INTO category(category) VALUE
('Công nghệ thông tin'),
('Thể Thao'),
('Thời trang');

INSERT INTO blog(status_delete, tittle, blog_detail_id, category_id) VALUE
(0, '[NGẪM] NGƯỜI TA KHÔNG ĐÁNH GIÁ BẠN QUA KĨ NĂNG, MÀ ĐÁNH GIÁ THEO THÀNH TỰU', 1, 1),
(0, 'MẶT TỐI CỦA NGÀNH CÔNG NGHIỆP IT', 2, 1),
(0, 'NĂM ĐIỀU LẬP TRÌNH VIÊN NÊN HỌC HỎI TỪ SƠN TÙNG MTP', 3, 1),
(0, 'LỢI ÍCH CỦA VIỆC ĐÁNH BÓNG HÀNG TUẦN', 4, 2),
(0, 'NHỮNG ĐIỀU BÍ ẨN SAU TRẬN CHUNG KẾT CUP C1', 5, 2),
(0, 'NÓI CHUYỆN PHIẾM VỀ THỜI TRANG HÈ 2022', 6, 3);