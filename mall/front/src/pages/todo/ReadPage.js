import {
  createSearchParams,
  useNavigate,
  useParams,
  useSearchParams,
} from "react-router-dom";
import { useCallback } from "react";

const ReadPage = () => {
  const { tno } = useParams();

  const navigate = useNavigate();
  const [queryParams] = useSearchParams();

  const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1;
  const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10;

  const queryStr = createSearchParams({ page, size }).toString();

  const moveToModify = useCallback(
    (tno) => {
      navigate({
        pathname: `/todo/modify/${tno}`,
        search: queryStr,
      });
    },
    [tno, page, size],
  );

  const moveToList = useCallback(() => {
    //query string 유지한 채로 이동
    navigate({ pathname: `/todo/list`, search: queryStr });
  }, [page, size]);

  return (
    <div className={"text-3xl font-extrabold"}>
      <ul>
        <li></li>
        Todo Read Page Component : {tno}
      </ul>

      <div>
        <div>
          <button onClick={() => moveToModify(tno)}>Test Modify</button>
        </div>
        <div>
          <button onClick={() => moveToList()}>Test List</button>
        </div>
      </div>
    </div>
  );
};

export default ReadPage;
