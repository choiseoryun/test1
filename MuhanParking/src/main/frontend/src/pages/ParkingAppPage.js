import React from "react";
import axios from "axios";

function Applicants() {
    return (
        <div style={styles.container}>
            <h1 style={styles.title}>정기주차 신청자 조회</h1>
            {/* {loading && <p>데이터를 불러오는 중...</p>}
            {error && <p style={styles.error}>{error}</p>} */}
            <table style={styles.table}>
                <thead>
                    <tr>
                        <th style={styles.th}>이름</th>
                        <th style={styles.th}>학번</th>
                        <th style={styles.th}>걸리는 시간</th>
                        <th style={styles.th} colSpan={3}></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style={styles.td}>기만</td>
                        <td style={styles.td}>202235950</td>
                        <td style={styles.td}>29314</td>
                        <td style={styles.td}><a href="/applicants/deceit">상세</a></td>
                        <td style={styles.td}><a href='#'>합격</a></td>
                        <td style={styles.td}><a href='#'>불합격</a></td>
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
      color: '#FFFFFF',
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

export default Applicants;