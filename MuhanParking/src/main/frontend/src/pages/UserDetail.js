import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function UserDetail() {
    return (
        <div style={styles.container}>
            <h1 style={styles.title}>사용자 상세정보 조회</h1>
            {/* {loading && <p>데이터를 불러오는 중...</p>}
            {error && <p style={styles.error}>{error}</p>} */}
            <table style={styles.table}>
                <thead>
                    <tr>
                        <th style={styles.th}>아이디</th>
                        <th style={styles.th}>이름</th>
                        <th style={styles.th}>성별</th>
                        <th style={styles.th}>핸드폰번호</th>
                        <th style={styles.th}>주소</th>
                        <th style={styles.th}>학번</th>
                        <th style={styles.th}>학과</th>
                        <th style={styles.th}>생년월일</th>
                        <th style={styles.th}></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style={styles.td}>hwan</td>
                        <td style={styles.td}>김환</td>
                        <td style={styles.td}>남</td>
                        <td style={styles.td}>010-1234-5678</td>
                        <td style={styles.td}>경기도 성남</td>
                        <td style={styles.td}>202135950</td>
                        <td style={styles.td}>컴퓨터공학과</td>
                        <td style={styles.td}>2002.03.28</td>
                        <td style={styles.td}><a href='/users/edit'>수정</a></td>
                    </tr>
                </tbody>
            </table>
            <footer style={{
                textAlign: 'center',
                marginTop: '40px',
                color: '#888',
                }}>
                <p>© 2024 가천대학교 P-실무프로젝트 무한이 주차비서 관리자 대시보드</p>
        </footer>
        </div>
        
    );
}

const styles = {
    container: { padding: '20px', textAlign: 'center', backgroundColor: '#F9F9F9' },
    title: { marginBottom: '20px' },
    table: {
      width: '100%',
      borderCollapse: 'collapse',
      margin: '0 auto',
      maxWidth: '800px',
    },
    th: {
      border: '1px solid #FFF',
      padding: '8px',
      color: '#FFF',
      backgroundColor: '#014f9e',
      fontWeight: 'bold',
    },
    td: {
      border: '1px solid #ddd',
      padding: '8px',
      textAlign: 'center',
    },
    error: {
      color: 'red',
      fontWeight: 'bold',
    },
};

export default UserDetail;