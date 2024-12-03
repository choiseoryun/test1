import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {Link, useNavigate} from 'react-router-dom';

function UserPage() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        axios.get('/api/v1/admin/users')
            .then(response => {
                setUsers(response.data);
                console.log(response.data)
            })
            .catch(error => {
                console.error("서버 요청 중 오류 발생:", error);
            });
    }, []);

    return (
        <div style={styles.container}>
            <h1 style={styles.title}>사용자 정보 조회</h1>
            {/* {loading && <p>데이터를 불러오는 중...</p>}
            {error && <p style={styles.error}>{error}</p>} */}
            <table style={styles.table}>
                <thead>
                <tr>
                    <th style={styles.th}>학번</th>
                    <th style={styles.th}>이름</th>
                    <th style={styles.th}>정기주차 여부</th>
                    <th style={styles.th}></th>
                </tr>
                </thead>
                <tbody>

                {Object.keys(users).map((key, index) => (
                    <tr>
                        <td style={styles.td}>{users[key].studentId}</td>
                        <td style={styles.td}>{users[key].name}</td>
                        <td style={styles.td}>X</td>
                        <td><a href={`/users/${users[key].name}`}>상세</a></td>
                    </tr>
                ))}
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

export default UserPage;