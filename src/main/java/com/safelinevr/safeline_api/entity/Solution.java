package com.safelinevr.safeline_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 이 클래스가 데이터베이스의 테이블과 연결됨을 나타냅니다.
public class Solution {

    @Id // 이 필드가 테이블의 고유 식별자(Primary Key)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 값을 데이터베이스가 자동으로 생성하도록 합니다.
    private Long id;

    private String categoryTitle; // 예: "하드웨어 솔루션"

    private String name; // 예: "SAFELINE M4D"

    private String tagline; // 예: "세상에서 가장 스마트한..."

    private String image; // 이미지 파일 경로

    private String link; // 상세 페이지로 연결될 링크 (예: /solutions/safeline-m4d)
}