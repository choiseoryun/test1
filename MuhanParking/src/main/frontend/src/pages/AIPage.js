import React from "react";
import { useNavigate } from "react-router-dom";

function AIPage() {
    const navigate = useNavigate();

    const handleParkingModel = () => {
        navigate('/ai/parking-model');
    }

    const handleRecommend = () => {
        navigate('/ai/analyze');
    }

    return (
        <div style={styles.container}>
            <header style={{
                textAlign: 'center',
                marginBottom: '20px',
            }}>
                <h1>AI 관련 메뉴</h1>
            </header>
            
            <button onClick={handleParkingModel} style={{ ...styles.button, width: '10%' }}>공간 탐지 모델 조회</button>
            {/* 모니터링이 사라졌으니 수정 요망. */}
            <button onClick={handleRecommend} style={{ ...styles.button, width: '10%' }}>통계 및 분석</button>

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
    button: {
        padding: '10px 15px',
        fontSize: '16px',
        color: '#fff',
        background: '#00C6FF',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
        margin: '10px'
    },
};

export default AIPage;