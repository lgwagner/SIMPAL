/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.atc.limp.LimpFactory
 * @model kind="package"
 * @generated
 */
public interface LimpPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "limp";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.rockwellcollins.com/atc/Limp";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "limp";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LimpPackage eINSTANCE = com.rockwellcollins.atc.limp.impl.LimpPackageImpl.init();

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.SpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.SpecificationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__DECLARATIONS = 0;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.DeclarationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 1;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.CommentImpl <em>Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.CommentImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getComment()
   * @generated
   */
  int COMMENT = 2;

  /**
   * The feature id for the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENT__COMMENT = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENT_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ImportImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 3;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ExternalFunctionImpl <em>External Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ExternalFunctionImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExternalFunction()
   * @generated
   */
  int EXTERNAL_FUNCTION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION__INPUTS = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION__OUTPUT = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>External Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FUNCTION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ExternalProcedureImpl <em>External Procedure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ExternalProcedureImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExternalProcedure()
   * @generated
   */
  int EXTERNAL_PROCEDURE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PROCEDURE__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PROCEDURE__INPUTS = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PROCEDURE__OUTPUTS = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attribute Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PROCEDURE__ATTRIBUTE_BLOCK = DECLARATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>External Procedure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_PROCEDURE_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl <em>Local Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.LocalFunctionImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalFunction()
   * @generated
   */
  int LOCAL_FUNCTION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION__INPUTS = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION__OUTPUT = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Var Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION__VAR_BLOCK = DECLARATION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Equation Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION__EQUATION_BLOCK = DECLARATION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Local Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_FUNCTION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl <em>Local Procedure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.LocalProcedureImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalProcedure()
   * @generated
   */
  int LOCAL_PROCEDURE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__INPUTS = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__OUTPUTS = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Var Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__VAR_BLOCK = DECLARATION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Attribute Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__ATTRIBUTE_BLOCK = DECLARATION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Statementblock</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE__STATEMENTBLOCK = DECLARATION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Local Procedure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_PROCEDURE_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.TypeDeclarationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTypeDeclaration()
   * @generated
   */
  int TYPE_DECLARATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.VarBlockImpl <em>Var Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.VarBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVarBlock()
   * @generated
   */
  int VAR_BLOCK = 9;

  /**
   * The number of structural features of the '<em>Var Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_BLOCK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.EnumTypeDefImpl <em>Enum Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.EnumTypeDefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumTypeDef()
   * @generated
   */
  int ENUM_TYPE_DEF = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF__NAME = TYPE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Enumerations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF__ENUMERATIONS = TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_DEF_FEATURE_COUNT = TYPE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.VariableRefImpl <em>Variable Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.VariableRefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVariableRef()
   * @generated
   */
  int VARIABLE_REF = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.EnumValueImpl <em>Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.EnumValueImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumValue()
   * @generated
   */
  int ENUM_VALUE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__NAME = VARIABLE_REF__NAME;

  /**
   * The number of structural features of the '<em>Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordTypeDefImpl <em>Record Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordTypeDefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordTypeDef()
   * @generated
   */
  int RECORD_TYPE_DEF = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF__NAME = TYPE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF__FIELDS = TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_DEF_FEATURE_COUNT = TYPE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ArrayTypeDefImpl <em>Array Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ArrayTypeDefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayTypeDef()
   * @generated
   */
  int ARRAY_TYPE_DEF = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__NAME = TYPE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__BASE_TYPE = TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF__SIZE = TYPE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_DEF_FEATURE_COUNT = TYPE_DECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.AbstractTypeDefImpl <em>Abstract Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.AbstractTypeDefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAbstractTypeDef()
   * @generated
   */
  int ABSTRACT_TYPE_DEF = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_DEF__NAME = TYPE_DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Abstract Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_DEF_FEATURE_COUNT = TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl <em>Record Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordFieldType()
   * @generated
   */
  int RECORD_FIELD_TYPE = 15;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_TYPE__FIELD_NAME = 0;

  /**
   * The feature id for the '<em><b>Field Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_TYPE__FIELD_TYPE = 1;

  /**
   * The number of structural features of the '<em>Record Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ConstantDeclarationImpl <em>Constant Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ConstantDeclarationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getConstantDeclaration()
   * @generated
   */
  int CONSTANT_DECLARATION = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION__TYPE = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION__EXPR = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constant Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.GlobalDeclarationImpl <em>Global Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.GlobalDeclarationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getGlobalDeclaration()
   * @generated
   */
  int GLOBAL_DECLARATION = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_DECLARATION__NAME = DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_DECLARATION__TYPE = DECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Global Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.InputArgListImpl <em>Input Arg List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.InputArgListImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInputArgList()
   * @generated
   */
  int INPUT_ARG_LIST = 19;

  /**
   * The feature id for the '<em><b>Input Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ARG_LIST__INPUT_ARGS = 0;

  /**
   * The number of structural features of the '<em>Input Arg List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ARG_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.InputArgImpl <em>Input Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.InputArgImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInputArg()
   * @generated
   */
  int INPUT_ARG = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ARG__NAME = VARIABLE_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ARG__TYPE = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Input Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ARG_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.LocalArgImpl <em>Local Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.LocalArgImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalArg()
   * @generated
   */
  int LOCAL_ARG = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_ARG__NAME = VARIABLE_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_ARG__TYPE = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Local Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_ARG_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.OutputArgListImpl <em>Output Arg List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.OutputArgListImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getOutputArgList()
   * @generated
   */
  int OUTPUT_ARG_LIST = 22;

  /**
   * The feature id for the '<em><b>Output Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_ARG_LIST__OUTPUT_ARGS = 0;

  /**
   * The number of structural features of the '<em>Output Arg List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_ARG_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.OutputArgImpl <em>Output Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.OutputArgImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getOutputArg()
   * @generated
   */
  int OUTPUT_ARG = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_ARG__NAME = VARIABLE_REF__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_ARG__TYPE = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Output Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_ARG_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.TypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getType()
   * @generated
   */
  int TYPE = 24;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.AttributeBlockImpl <em>Attribute Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.AttributeBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAttributeBlock()
   * @generated
   */
  int ATTRIBUTE_BLOCK = 25;

  /**
   * The number of structural features of the '<em>Attribute Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_BLOCK_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.AttributeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 26;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.PreconditionImpl <em>Precondition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.PreconditionImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getPrecondition()
   * @generated
   */
  int PRECONDITION = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION__NAME = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION__EXPR = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Precondition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.PostconditionImpl <em>Postcondition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.PostconditionImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getPostcondition()
   * @generated
   */
  int POSTCONDITION = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION__NAME = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION__EXPR = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Postcondition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.DefineUseRefImpl <em>Define Use Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.DefineUseRefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDefineUseRef()
   * @generated
   */
  int DEFINE_USE_REF = 29;

  /**
   * The feature id for the '<em><b>Reference Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_USE_REF__REFERENCE_EXPR = 0;

  /**
   * The number of structural features of the '<em>Define Use Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_USE_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.DefineImpl <em>Define</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.DefineImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDefine()
   * @generated
   */
  int DEFINE = 30;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE__ELEMENTS = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Define</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.UsesImpl <em>Uses</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.UsesImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUses()
   * @generated
   */
  int USES = 31;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES__ELEMENTS = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Uses</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.StatementBlockImpl <em>Statement Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.StatementBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStatementBlock()
   * @generated
   */
  int STATEMENT_BLOCK = 32;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Statement Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.StatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 33;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.VoidStatementImpl <em>Void Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.VoidStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVoidStatement()
   * @generated
   */
  int VOID_STATEMENT = 34;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VOID_STATEMENT__EXPR = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Void Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VOID_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAssignmentStatement()
   * @generated
   */
  int ASSIGNMENT_STATEMENT = 35;

  /**
   * The feature id for the '<em><b>Ids</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STATEMENT__IDS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STATEMENT__RHS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl <em>If Then Else Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIfThenElseStatement()
   * @generated
   */
  int IF_THEN_ELSE_STATEMENT = 36;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_STATEMENT__COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_STATEMENT__THEN_BLOCK = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_STATEMENT__ELSE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ElseImpl <em>Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ElseImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElse()
   * @generated
   */
  int ELSE = 37;

  /**
   * The number of structural features of the '<em>Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.WhileStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 38;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__BLOCK = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl <em>For Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ForStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getForStatement()
   * @generated
   */
  int FOR_STATEMENT = 39;

  /**
   * The feature id for the '<em><b>Init Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__INIT_STATEMENT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Limit Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__LIMIT_EXPR = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Increment Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__INCREMENT_STATEMENT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__BLOCK = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>For Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.LabelStatementImpl <em>Label Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.LabelStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLabelStatement()
   * @generated
   */
  int LABEL_STATEMENT = 40;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_STATEMENT__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Label Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.GotoStatementImpl <em>Goto Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.GotoStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getGotoStatement()
   * @generated
   */
  int GOTO_STATEMENT = 41;

  /**
   * The feature id for the '<em><b>Label</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOTO_STATEMENT__LABEL = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>When Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOTO_STATEMENT__WHEN_EXPR = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Goto Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOTO_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.EquationBlockImpl <em>Equation Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.EquationBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEquationBlock()
   * @generated
   */
  int EQUATION_BLOCK = 42;

  /**
   * The feature id for the '<em><b>Equations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_BLOCK__EQUATIONS = 0;

  /**
   * The number of structural features of the '<em>Equation Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.EquationImpl <em>Equation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.EquationImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEquation()
   * @generated
   */
  int EQUATION = 43;

  /**
   * The number of structural features of the '<em>Equation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IdListImpl <em>Id List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IdListImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIdList()
   * @generated
   */
  int ID_LIST = 44;

  /**
   * The feature id for the '<em><b>Ids</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_LIST__IDS = 0;

  /**
   * The number of structural features of the '<em>Id List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 45;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.FunctionRefImpl <em>Function Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.FunctionRefImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFunctionRef()
   * @generated
   */
  int FUNCTION_REF = 46;

  /**
   * The number of structural features of the '<em>Function Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ArrayExprImpl <em>Array Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ArrayExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayExpr()
   * @generated
   */
  int ARRAY_EXPR = 47;

  /**
   * The feature id for the '<em><b>Array Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR__ARRAY_DEFINITION = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR__EXPR_LIST = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordExprImpl <em>Record Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordExpr()
   * @generated
   */
  int RECORD_EXPR = 48;

  /**
   * The feature id for the '<em><b>Record Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__RECORD_DEFINITION = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field Expr List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__FIELD_EXPR_LIST = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordFieldExpr()
   * @generated
   */
  int RECORD_FIELD_EXPR = 49;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__FIELD_NAME = 0;

  /**
   * The feature id for the '<em><b>Field Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__FIELD_EXPR = 1;

  /**
   * The number of structural features of the '<em>Record Field Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ExprListImpl <em>Expr List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ExprListImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExprList()
   * @generated
   */
  int EXPR_LIST = 50;

  /**
   * The feature id for the '<em><b>Expr List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIST__EXPR_LIST = 0;

  /**
   * The number of structural features of the '<em>Expr List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.TypeAliasImpl <em>Type Alias</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.TypeAliasImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTypeAlias()
   * @generated
   */
  int TYPE_ALIAS = 51;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS__NAME = TYPE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS__TYPE = TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Alias</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS_FEATURE_COUNT = TYPE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.SomeVarBlockImpl <em>Some Var Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.SomeVarBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSomeVarBlock()
   * @generated
   */
  int SOME_VAR_BLOCK = 52;

  /**
   * The feature id for the '<em><b>Locals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_VAR_BLOCK__LOCALS = VAR_BLOCK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Some Var Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_VAR_BLOCK_FEATURE_COUNT = VAR_BLOCK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.NoVarBlockImpl <em>No Var Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.NoVarBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoVarBlock()
   * @generated
   */
  int NO_VAR_BLOCK = 53;

  /**
   * The number of structural features of the '<em>No Var Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_VAR_BLOCK_FEATURE_COUNT = VAR_BLOCK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.VoidTypeImpl <em>Void Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.VoidTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVoidType()
   * @generated
   */
  int VOID_TYPE = 54;

  /**
   * The number of structural features of the '<em>Void Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VOID_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.BoolTypeImpl <em>Bool Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.BoolTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBoolType()
   * @generated
   */
  int BOOL_TYPE = 55;

  /**
   * The number of structural features of the '<em>Bool Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IntegerTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 56;

  /**
   * The number of structural features of the '<em>Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RealTypeImpl <em>Real Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RealTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRealType()
   * @generated
   */
  int REAL_TYPE = 57;

  /**
   * The number of structural features of the '<em>Real Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.StringTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 58;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.EnumTypeImpl <em>Enum Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.EnumTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumType()
   * @generated
   */
  int ENUM_TYPE = 59;

  /**
   * The feature id for the '<em><b>Enum Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__ENUM_DEF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordTypeImpl <em>Record Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordType()
   * @generated
   */
  int RECORD_TYPE = 60;

  /**
   * The feature id for the '<em><b>Record Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__RECORD_DEF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ArrayTypeImpl <em>Array Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ArrayTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayType()
   * @generated
   */
  int ARRAY_TYPE = 61;

  /**
   * The feature id for the '<em><b>Array Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__ARRAY_DEF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.AbstractTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAbstractType()
   * @generated
   */
  int ABSTRACT_TYPE = 62;

  /**
   * The feature id for the '<em><b>Abstract Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE__ABSTRACT_DEF = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.NamedTypeImpl <em>Named Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.NamedTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNamedType()
   * @generated
   */
  int NAMED_TYPE = 63;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE__ALIAS = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.SomeAttributeBlockImpl <em>Some Attribute Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.SomeAttributeBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSomeAttributeBlock()
   * @generated
   */
  int SOME_ATTRIBUTE_BLOCK = 64;

  /**
   * The feature id for the '<em><b>Attribute List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST = ATTRIBUTE_BLOCK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Some Attribute Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_ATTRIBUTE_BLOCK_FEATURE_COUNT = ATTRIBUTE_BLOCK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.NoAttributeBlockImpl <em>No Attribute Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.NoAttributeBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoAttributeBlock()
   * @generated
   */
  int NO_ATTRIBUTE_BLOCK = 65;

  /**
   * The number of structural features of the '<em>No Attribute Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_ATTRIBUTE_BLOCK_FEATURE_COUNT = ATTRIBUTE_BLOCK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.BreakStatementImpl <em>Break Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.BreakStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBreakStatement()
   * @generated
   */
  int BREAK_STATEMENT = 66;

  /**
   * The number of structural features of the '<em>Break Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ContinueStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getContinueStatement()
   * @generated
   */
  int CONTINUE_STATEMENT = 67;

  /**
   * The number of structural features of the '<em>Continue Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTINUE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ReturnStatementImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 68;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ElseBlockImpl <em>Else Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ElseBlockImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElseBlock()
   * @generated
   */
  int ELSE_BLOCK = 69;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_BLOCK__BLOCK = ELSE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Else Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_BLOCK_FEATURE_COUNT = ELSE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ElseIfImpl <em>Else If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ElseIfImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElseIf()
   * @generated
   */
  int ELSE_IF = 70;

  /**
   * The feature id for the '<em><b>If Then Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF__IF_THEN_ELSE = ELSE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Else If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_FEATURE_COUNT = ELSE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.NoElseImpl <em>No Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.NoElseImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoElse()
   * @generated
   */
  int NO_ELSE = 71;

  /**
   * The number of structural features of the '<em>No Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_ELSE_FEATURE_COUNT = ELSE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIfThenElseExpr()
   * @generated
   */
  int IF_THEN_ELSE_EXPR = 72;

  /**
   * The feature id for the '<em><b>Cond Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__COND_EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__THEN_EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__ELSE_EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ChoiceExprImpl <em>Choice Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ChoiceExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getChoiceExpr()
   * @generated
   */
  int CHOICE_EXPR = 73;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_EXPR__FIRST = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_EXPR__SECOND = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Choice Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.BinaryExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBinaryExpr()
   * @generated
   */
  int BINARY_EXPR = 74;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.UnaryNegationExprImpl <em>Unary Negation Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.UnaryNegationExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUnaryNegationExpr()
   * @generated
   */
  int UNARY_NEGATION_EXPR = 75;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_NEGATION_EXPR__EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unary Negation Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_NEGATION_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.UnaryMinusExprImpl <em>Unary Minus Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.UnaryMinusExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUnaryMinusExpr()
   * @generated
   */
  int UNARY_MINUS_EXPR = 76;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MINUS_EXPR__EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unary Minus Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MINUS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordAccessExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordAccessExpr()
   * @generated
   */
  int RECORD_ACCESS_EXPR = 77;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__RECORD = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__FIELD = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl <em>Record Update Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordUpdateExpr()
   * @generated
   */
  int RECORD_UPDATE_EXPR = 78;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__RECORD = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__FIELD = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR__VALUE = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Record Update Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_UPDATE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ArrayAccessExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayAccessExpr()
   * @generated
   */
  int ARRAY_ACCESS_EXPR = 79;

  /**
   * The feature id for the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__ARRAY = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__INDEX = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.ArrayUpdateExprImpl <em>Array Update Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.ArrayUpdateExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayUpdateExpr()
   * @generated
   */
  int ARRAY_UPDATE_EXPR = 80;

  /**
   * The feature id for the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR__ACCESS = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR__VALUE = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Update Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_UPDATE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.BooleanLiteralExprImpl <em>Boolean Literal Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.BooleanLiteralExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBooleanLiteralExpr()
   * @generated
   */
  int BOOLEAN_LITERAL_EXPR = 81;

  /**
   * The feature id for the '<em><b>Bool Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXPR__BOOL_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IntegerLiteralExprImpl <em>Integer Literal Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IntegerLiteralExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerLiteralExpr()
   * @generated
   */
  int INTEGER_LITERAL_EXPR = 82;

  /**
   * The feature id for the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_EXPR__INT_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Literal Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IntegerWildCardExprImpl <em>Integer Wild Card Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IntegerWildCardExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerWildCardExpr()
   * @generated
   */
  int INTEGER_WILD_CARD_EXPR = 83;

  /**
   * The number of structural features of the '<em>Integer Wild Card Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_WILD_CARD_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.RealLiteralExprImpl <em>Real Literal Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.RealLiteralExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRealLiteralExpr()
   * @generated
   */
  int REAL_LITERAL_EXPR = 84;

  /**
   * The feature id for the '<em><b>Real Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_EXPR__REAL_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.StringLiteralExprImpl <em>String Literal Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.StringLiteralExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStringLiteralExpr()
   * @generated
   */
  int STRING_LITERAL_EXPR = 85;

  /**
   * The feature id for the '<em><b>String Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXPR__STRING_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.InitExprImpl <em>Init Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.InitExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInitExpr()
   * @generated
   */
  int INIT_EXPR = 86;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Init Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.SecondInitImpl <em>Second Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.SecondInitImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSecondInit()
   * @generated
   */
  int SECOND_INIT = 87;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_INIT__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Second Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_INIT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.IdExprImpl <em>Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.IdExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIdExpr()
   * @generated
   */
  int ID_EXPR = 88;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.FcnCallExprImpl <em>Fcn Call Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.FcnCallExprImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFcnCallExpr()
   * @generated
   */
  int FCN_CALL_EXPR = 89;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FCN_CALL_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FCN_CALL_EXPR__EXPRS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fcn Call Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FCN_CALL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.TupleTypeImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 90;

  /**
   * The feature id for the '<em><b>Type List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__TYPE_LIST = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.limp.impl.FreshVariableImpl <em>Fresh Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.limp.impl.FreshVariableImpl
   * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFreshVariable()
   * @generated
   */
  int FRESH_VARIABLE = 91;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRESH_VARIABLE__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fresh Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRESH_VARIABLE_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see com.rockwellcollins.atc.limp.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.Specification#getDeclarations <em>Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarations</em>'.
   * @see com.rockwellcollins.atc.limp.Specification#getDeclarations()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Declarations();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see com.rockwellcollins.atc.limp.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Comment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comment</em>'.
   * @see com.rockwellcollins.atc.limp.Comment
   * @generated
   */
  EClass getComment();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.Comment#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comment</em>'.
   * @see com.rockwellcollins.atc.limp.Comment#getComment()
   * @see #getComment()
   * @generated
   */
  EAttribute getComment_Comment();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see com.rockwellcollins.atc.limp.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see com.rockwellcollins.atc.limp.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ExternalFunction <em>External Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Function</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalFunction
   * @generated
   */
  EClass getExternalFunction();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.ExternalFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalFunction#getName()
   * @see #getExternalFunction()
   * @generated
   */
  EAttribute getExternalFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ExternalFunction#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inputs</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalFunction#getInputs()
   * @see #getExternalFunction()
   * @generated
   */
  EReference getExternalFunction_Inputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ExternalFunction#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalFunction#getOutput()
   * @see #getExternalFunction()
   * @generated
   */
  EReference getExternalFunction_Output();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ExternalProcedure <em>External Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Procedure</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure
   * @generated
   */
  EClass getExternalProcedure();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure#getName()
   * @see #getExternalProcedure()
   * @generated
   */
  EAttribute getExternalProcedure_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inputs</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure#getInputs()
   * @see #getExternalProcedure()
   * @generated
   */
  EReference getExternalProcedure_Inputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getOutputs <em>Outputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outputs</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure#getOutputs()
   * @see #getExternalProcedure()
   * @generated
   */
  EReference getExternalProcedure_Outputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getAttributeBlock <em>Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attribute Block</em>'.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure#getAttributeBlock()
   * @see #getExternalProcedure()
   * @generated
   */
  EReference getExternalProcedure_AttributeBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.LocalFunction <em>Local Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Function</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction
   * @generated
   */
  EClass getLocalFunction();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.LocalFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction#getName()
   * @see #getLocalFunction()
   * @generated
   */
  EAttribute getLocalFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalFunction#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inputs</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction#getInputs()
   * @see #getLocalFunction()
   * @generated
   */
  EReference getLocalFunction_Inputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalFunction#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction#getOutput()
   * @see #getLocalFunction()
   * @generated
   */
  EReference getLocalFunction_Output();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalFunction#getVarBlock <em>Var Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Block</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction#getVarBlock()
   * @see #getLocalFunction()
   * @generated
   */
  EReference getLocalFunction_VarBlock();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalFunction#getEquationBlock <em>Equation Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Equation Block</em>'.
   * @see com.rockwellcollins.atc.limp.LocalFunction#getEquationBlock()
   * @see #getLocalFunction()
   * @generated
   */
  EReference getLocalFunction_EquationBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.LocalProcedure <em>Local Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Procedure</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure
   * @generated
   */
  EClass getLocalProcedure();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.LocalProcedure#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getName()
   * @see #getLocalProcedure()
   * @generated
   */
  EAttribute getLocalProcedure_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalProcedure#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inputs</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getInputs()
   * @see #getLocalProcedure()
   * @generated
   */
  EReference getLocalProcedure_Inputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalProcedure#getOutputs <em>Outputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outputs</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getOutputs()
   * @see #getLocalProcedure()
   * @generated
   */
  EReference getLocalProcedure_Outputs();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalProcedure#getVarBlock <em>Var Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Block</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getVarBlock()
   * @see #getLocalProcedure()
   * @generated
   */
  EReference getLocalProcedure_VarBlock();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalProcedure#getAttributeBlock <em>Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attribute Block</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getAttributeBlock()
   * @see #getLocalProcedure()
   * @generated
   */
  EReference getLocalProcedure_AttributeBlock();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalProcedure#getStatementblock <em>Statementblock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statementblock</em>'.
   * @see com.rockwellcollins.atc.limp.LocalProcedure#getStatementblock()
   * @see #getLocalProcedure()
   * @generated
   */
  EReference getLocalProcedure_Statementblock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.TypeDeclaration <em>Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Declaration</em>'.
   * @see com.rockwellcollins.atc.limp.TypeDeclaration
   * @generated
   */
  EClass getTypeDeclaration();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.TypeDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.TypeDeclaration#getName()
   * @see #getTypeDeclaration()
   * @generated
   */
  EAttribute getTypeDeclaration_Name();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.VarBlock <em>Var Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Block</em>'.
   * @see com.rockwellcollins.atc.limp.VarBlock
   * @generated
   */
  EClass getVarBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.EnumTypeDef <em>Enum Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type Def</em>'.
   * @see com.rockwellcollins.atc.limp.EnumTypeDef
   * @generated
   */
  EClass getEnumTypeDef();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.EnumTypeDef#getEnumerations <em>Enumerations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumerations</em>'.
   * @see com.rockwellcollins.atc.limp.EnumTypeDef#getEnumerations()
   * @see #getEnumTypeDef()
   * @generated
   */
  EReference getEnumTypeDef_Enumerations();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Value</em>'.
   * @see com.rockwellcollins.atc.limp.EnumValue
   * @generated
   */
  EClass getEnumValue();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordTypeDef <em>Record Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type Def</em>'.
   * @see com.rockwellcollins.atc.limp.RecordTypeDef
   * @generated
   */
  EClass getRecordTypeDef();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.RecordTypeDef#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see com.rockwellcollins.atc.limp.RecordTypeDef#getFields()
   * @see #getRecordTypeDef()
   * @generated
   */
  EReference getRecordTypeDef_Fields();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ArrayTypeDef <em>Array Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type Def</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayTypeDef
   * @generated
   */
  EClass getArrayTypeDef();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getBaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base Type</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayTypeDef#getBaseType()
   * @see #getArrayTypeDef()
   * @generated
   */
  EReference getArrayTypeDef_BaseType();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayTypeDef#getSize()
   * @see #getArrayTypeDef()
   * @generated
   */
  EAttribute getArrayTypeDef_Size();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.AbstractTypeDef <em>Abstract Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Type Def</em>'.
   * @see com.rockwellcollins.atc.limp.AbstractTypeDef
   * @generated
   */
  EClass getAbstractTypeDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordFieldType <em>Record Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Type</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldType
   * @generated
   */
  EClass getRecordFieldType();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldName <em>Field Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field Name</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldType#getFieldName()
   * @see #getRecordFieldType()
   * @generated
   */
  EAttribute getRecordFieldType_FieldName();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field Type</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldType#getFieldType()
   * @see #getRecordFieldType()
   * @generated
   */
  EReference getRecordFieldType_FieldType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ConstantDeclaration <em>Constant Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Declaration</em>'.
   * @see com.rockwellcollins.atc.limp.ConstantDeclaration
   * @generated
   */
  EClass getConstantDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ConstantDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.ConstantDeclaration#getType()
   * @see #getConstantDeclaration()
   * @generated
   */
  EReference getConstantDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ConstantDeclaration#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ConstantDeclaration#getExpr()
   * @see #getConstantDeclaration()
   * @generated
   */
  EReference getConstantDeclaration_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.GlobalDeclaration <em>Global Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Declaration</em>'.
   * @see com.rockwellcollins.atc.limp.GlobalDeclaration
   * @generated
   */
  EClass getGlobalDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.GlobalDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.GlobalDeclaration#getType()
   * @see #getGlobalDeclaration()
   * @generated
   */
  EReference getGlobalDeclaration_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Ref</em>'.
   * @see com.rockwellcollins.atc.limp.VariableRef
   * @generated
   */
  EClass getVariableRef();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.VariableRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.VariableRef#getName()
   * @see #getVariableRef()
   * @generated
   */
  EAttribute getVariableRef_Name();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.InputArgList <em>Input Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Arg List</em>'.
   * @see com.rockwellcollins.atc.limp.InputArgList
   * @generated
   */
  EClass getInputArgList();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.InputArgList#getInputArgs <em>Input Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Input Args</em>'.
   * @see com.rockwellcollins.atc.limp.InputArgList#getInputArgs()
   * @see #getInputArgList()
   * @generated
   */
  EReference getInputArgList_InputArgs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.InputArg <em>Input Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Arg</em>'.
   * @see com.rockwellcollins.atc.limp.InputArg
   * @generated
   */
  EClass getInputArg();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.InputArg#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.InputArg#getType()
   * @see #getInputArg()
   * @generated
   */
  EReference getInputArg_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.LocalArg <em>Local Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Arg</em>'.
   * @see com.rockwellcollins.atc.limp.LocalArg
   * @generated
   */
  EClass getLocalArg();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.LocalArg#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.LocalArg#getType()
   * @see #getLocalArg()
   * @generated
   */
  EReference getLocalArg_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.OutputArgList <em>Output Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Arg List</em>'.
   * @see com.rockwellcollins.atc.limp.OutputArgList
   * @generated
   */
  EClass getOutputArgList();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.OutputArgList#getOutputArgs <em>Output Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Output Args</em>'.
   * @see com.rockwellcollins.atc.limp.OutputArgList#getOutputArgs()
   * @see #getOutputArgList()
   * @generated
   */
  EReference getOutputArgList_OutputArgs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.OutputArg <em>Output Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Arg</em>'.
   * @see com.rockwellcollins.atc.limp.OutputArg
   * @generated
   */
  EClass getOutputArg();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.OutputArg#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.OutputArg#getType()
   * @see #getOutputArg()
   * @generated
   */
  EReference getOutputArg_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.AttributeBlock <em>Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Block</em>'.
   * @see com.rockwellcollins.atc.limp.AttributeBlock
   * @generated
   */
  EClass getAttributeBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see com.rockwellcollins.atc.limp.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Precondition <em>Precondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precondition</em>'.
   * @see com.rockwellcollins.atc.limp.Precondition
   * @generated
   */
  EClass getPrecondition();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.Precondition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.Precondition#getName()
   * @see #getPrecondition()
   * @generated
   */
  EAttribute getPrecondition_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.Precondition#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.Precondition#getExpr()
   * @see #getPrecondition()
   * @generated
   */
  EReference getPrecondition_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Postcondition <em>Postcondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postcondition</em>'.
   * @see com.rockwellcollins.atc.limp.Postcondition
   * @generated
   */
  EClass getPostcondition();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.Postcondition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.Postcondition#getName()
   * @see #getPostcondition()
   * @generated
   */
  EAttribute getPostcondition_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.Postcondition#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.Postcondition#getExpr()
   * @see #getPostcondition()
   * @generated
   */
  EReference getPostcondition_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.DefineUseRef <em>Define Use Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Use Ref</em>'.
   * @see com.rockwellcollins.atc.limp.DefineUseRef
   * @generated
   */
  EClass getDefineUseRef();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.DefineUseRef#getReferenceExpr <em>Reference Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Expr</em>'.
   * @see com.rockwellcollins.atc.limp.DefineUseRef#getReferenceExpr()
   * @see #getDefineUseRef()
   * @generated
   */
  EReference getDefineUseRef_ReferenceExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Define <em>Define</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define</em>'.
   * @see com.rockwellcollins.atc.limp.Define
   * @generated
   */
  EClass getDefine();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.Define#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see com.rockwellcollins.atc.limp.Define#getElements()
   * @see #getDefine()
   * @generated
   */
  EReference getDefine_Elements();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Uses <em>Uses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uses</em>'.
   * @see com.rockwellcollins.atc.limp.Uses
   * @generated
   */
  EClass getUses();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.Uses#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see com.rockwellcollins.atc.limp.Uses#getElements()
   * @see #getUses()
   * @generated
   */
  EReference getUses_Elements();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.StatementBlock <em>Statement Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement Block</em>'.
   * @see com.rockwellcollins.atc.limp.StatementBlock
   * @generated
   */
  EClass getStatementBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.StatementBlock#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see com.rockwellcollins.atc.limp.StatementBlock#getStatements()
   * @see #getStatementBlock()
   * @generated
   */
  EReference getStatementBlock_Statements();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see com.rockwellcollins.atc.limp.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.VoidStatement <em>Void Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Void Statement</em>'.
   * @see com.rockwellcollins.atc.limp.VoidStatement
   * @generated
   */
  EClass getVoidStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.VoidStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.VoidStatement#getExpr()
   * @see #getVoidStatement()
   * @generated
   */
  EReference getVoidStatement_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.AssignmentStatement <em>Assignment Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Statement</em>'.
   * @see com.rockwellcollins.atc.limp.AssignmentStatement
   * @generated
   */
  EClass getAssignmentStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.AssignmentStatement#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ids</em>'.
   * @see com.rockwellcollins.atc.limp.AssignmentStatement#getIds()
   * @see #getAssignmentStatement()
   * @generated
   */
  EReference getAssignmentStatement_Ids();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.AssignmentStatement#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see com.rockwellcollins.atc.limp.AssignmentStatement#getRhs()
   * @see #getAssignmentStatement()
   * @generated
   */
  EReference getAssignmentStatement_Rhs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IfThenElseStatement <em>If Then Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else Statement</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseStatement
   * @generated
   */
  EClass getIfThenElseStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseStatement#getCond()
   * @see #getIfThenElseStatement()
   * @generated
   */
  EReference getIfThenElseStatement_Cond();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getThenBlock <em>Then Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Block</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseStatement#getThenBlock()
   * @see #getIfThenElseStatement()
   * @generated
   */
  EReference getIfThenElseStatement_ThenBlock();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseStatement#getElse()
   * @see #getIfThenElseStatement()
   * @generated
   */
  EReference getIfThenElseStatement_Else();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Else <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else</em>'.
   * @see com.rockwellcollins.atc.limp.Else
   * @generated
   */
  EClass getElse();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see com.rockwellcollins.atc.limp.WhileStatement
   * @generated
   */
  EClass getWhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.WhileStatement#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see com.rockwellcollins.atc.limp.WhileStatement#getCond()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Cond();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.WhileStatement#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see com.rockwellcollins.atc.limp.WhileStatement#getBlock()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Block();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Statement</em>'.
   * @see com.rockwellcollins.atc.limp.ForStatement
   * @generated
   */
  EClass getForStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ForStatement#getInitStatement <em>Init Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Statement</em>'.
   * @see com.rockwellcollins.atc.limp.ForStatement#getInitStatement()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_InitStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ForStatement#getLimitExpr <em>Limit Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Limit Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ForStatement#getLimitExpr()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_LimitExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ForStatement#getIncrementStatement <em>Increment Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Increment Statement</em>'.
   * @see com.rockwellcollins.atc.limp.ForStatement#getIncrementStatement()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_IncrementStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ForStatement#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see com.rockwellcollins.atc.limp.ForStatement#getBlock()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Block();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.LabelStatement <em>Label Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label Statement</em>'.
   * @see com.rockwellcollins.atc.limp.LabelStatement
   * @generated
   */
  EClass getLabelStatement();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.LabelStatement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.rockwellcollins.atc.limp.LabelStatement#getName()
   * @see #getLabelStatement()
   * @generated
   */
  EAttribute getLabelStatement_Name();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.GotoStatement <em>Goto Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goto Statement</em>'.
   * @see com.rockwellcollins.atc.limp.GotoStatement
   * @generated
   */
  EClass getGotoStatement();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.GotoStatement#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Label</em>'.
   * @see com.rockwellcollins.atc.limp.GotoStatement#getLabel()
   * @see #getGotoStatement()
   * @generated
   */
  EReference getGotoStatement_Label();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.GotoStatement#getWhenExpr <em>When Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>When Expr</em>'.
   * @see com.rockwellcollins.atc.limp.GotoStatement#getWhenExpr()
   * @see #getGotoStatement()
   * @generated
   */
  EReference getGotoStatement_WhenExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.EquationBlock <em>Equation Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equation Block</em>'.
   * @see com.rockwellcollins.atc.limp.EquationBlock
   * @generated
   */
  EClass getEquationBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.EquationBlock#getEquations <em>Equations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equations</em>'.
   * @see com.rockwellcollins.atc.limp.EquationBlock#getEquations()
   * @see #getEquationBlock()
   * @generated
   */
  EReference getEquationBlock_Equations();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Equation <em>Equation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equation</em>'.
   * @see com.rockwellcollins.atc.limp.Equation
   * @generated
   */
  EClass getEquation();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IdList <em>Id List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id List</em>'.
   * @see com.rockwellcollins.atc.limp.IdList
   * @generated
   */
  EClass getIdList();

  /**
   * Returns the meta object for the reference list '{@link com.rockwellcollins.atc.limp.IdList#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ids</em>'.
   * @see com.rockwellcollins.atc.limp.IdList#getIds()
   * @see #getIdList()
   * @generated
   */
  EReference getIdList_Ids();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.FunctionRef <em>Function Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Ref</em>'.
   * @see com.rockwellcollins.atc.limp.FunctionRef
   * @generated
   */
  EClass getFunctionRef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayExpr
   * @generated
   */
  EClass getArrayExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.ArrayExpr#getArrayDefinition <em>Array Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Array Definition</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayExpr#getArrayDefinition()
   * @see #getArrayExpr()
   * @generated
   */
  EReference getArrayExpr_ArrayDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.ArrayExpr#getExprList <em>Expr List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr List</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayExpr#getExprList()
   * @see #getArrayExpr()
   * @generated
   */
  EReference getArrayExpr_ExprList();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordExpr <em>Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RecordExpr
   * @generated
   */
  EClass getRecordExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.RecordExpr#getRecordDefinition <em>Record Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Record Definition</em>'.
   * @see com.rockwellcollins.atc.limp.RecordExpr#getRecordDefinition()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_RecordDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.RecordExpr#getFieldExprList <em>Field Expr List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field Expr List</em>'.
   * @see com.rockwellcollins.atc.limp.RecordExpr#getFieldExprList()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_FieldExprList();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordFieldExpr <em>Record Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldExpr
   * @generated
   */
  EClass getRecordFieldExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldName <em>Field Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field Name</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldName()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EAttribute getRecordFieldExpr_FieldName();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldExpr <em>Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldExpr()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_FieldExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ExprList <em>Expr List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr List</em>'.
   * @see com.rockwellcollins.atc.limp.ExprList
   * @generated
   */
  EClass getExprList();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.ExprList#getExprList <em>Expr List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr List</em>'.
   * @see com.rockwellcollins.atc.limp.ExprList#getExprList()
   * @see #getExprList()
   * @generated
   */
  EReference getExprList_ExprList();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.TypeAlias <em>Type Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Alias</em>'.
   * @see com.rockwellcollins.atc.limp.TypeAlias
   * @generated
   */
  EClass getTypeAlias();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.TypeAlias#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.limp.TypeAlias#getType()
   * @see #getTypeAlias()
   * @generated
   */
  EReference getTypeAlias_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.SomeVarBlock <em>Some Var Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Some Var Block</em>'.
   * @see com.rockwellcollins.atc.limp.SomeVarBlock
   * @generated
   */
  EClass getSomeVarBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.SomeVarBlock#getLocals <em>Locals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Locals</em>'.
   * @see com.rockwellcollins.atc.limp.SomeVarBlock#getLocals()
   * @see #getSomeVarBlock()
   * @generated
   */
  EReference getSomeVarBlock_Locals();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.NoVarBlock <em>No Var Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Var Block</em>'.
   * @see com.rockwellcollins.atc.limp.NoVarBlock
   * @generated
   */
  EClass getNoVarBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.VoidType <em>Void Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Void Type</em>'.
   * @see com.rockwellcollins.atc.limp.VoidType
   * @generated
   */
  EClass getVoidType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Type</em>'.
   * @see com.rockwellcollins.atc.limp.BoolType
   * @generated
   */
  EClass getBoolType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Type</em>'.
   * @see com.rockwellcollins.atc.limp.IntegerType
   * @generated
   */
  EClass getIntegerType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RealType <em>Real Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Type</em>'.
   * @see com.rockwellcollins.atc.limp.RealType
   * @generated
   */
  EClass getRealType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see com.rockwellcollins.atc.limp.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type</em>'.
   * @see com.rockwellcollins.atc.limp.EnumType
   * @generated
   */
  EClass getEnumType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.EnumType#getEnumDef <em>Enum Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Def</em>'.
   * @see com.rockwellcollins.atc.limp.EnumType#getEnumDef()
   * @see #getEnumType()
   * @generated
   */
  EReference getEnumType_EnumDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordType <em>Record Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type</em>'.
   * @see com.rockwellcollins.atc.limp.RecordType
   * @generated
   */
  EClass getRecordType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.RecordType#getRecordDef <em>Record Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Record Def</em>'.
   * @see com.rockwellcollins.atc.limp.RecordType#getRecordDef()
   * @see #getRecordType()
   * @generated
   */
  EReference getRecordType_RecordDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayType
   * @generated
   */
  EClass getArrayType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.ArrayType#getArrayDef <em>Array Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Array Def</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayType#getArrayDef()
   * @see #getArrayType()
   * @generated
   */
  EReference getArrayType_ArrayDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.AbstractType <em>Abstract Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Type</em>'.
   * @see com.rockwellcollins.atc.limp.AbstractType
   * @generated
   */
  EClass getAbstractType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.AbstractType#getAbstractDef <em>Abstract Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Abstract Def</em>'.
   * @see com.rockwellcollins.atc.limp.AbstractType#getAbstractDef()
   * @see #getAbstractType()
   * @generated
   */
  EReference getAbstractType_AbstractDef();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.NamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Type</em>'.
   * @see com.rockwellcollins.atc.limp.NamedType
   * @generated
   */
  EClass getNamedType();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.NamedType#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see com.rockwellcollins.atc.limp.NamedType#getAlias()
   * @see #getNamedType()
   * @generated
   */
  EReference getNamedType_Alias();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.SomeAttributeBlock <em>Some Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Some Attribute Block</em>'.
   * @see com.rockwellcollins.atc.limp.SomeAttributeBlock
   * @generated
   */
  EClass getSomeAttributeBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.SomeAttributeBlock#getAttributeList <em>Attribute List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute List</em>'.
   * @see com.rockwellcollins.atc.limp.SomeAttributeBlock#getAttributeList()
   * @see #getSomeAttributeBlock()
   * @generated
   */
  EReference getSomeAttributeBlock_AttributeList();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.NoAttributeBlock <em>No Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Attribute Block</em>'.
   * @see com.rockwellcollins.atc.limp.NoAttributeBlock
   * @generated
   */
  EClass getNoAttributeBlock();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Break Statement</em>'.
   * @see com.rockwellcollins.atc.limp.BreakStatement
   * @generated
   */
  EClass getBreakStatement();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ContinueStatement <em>Continue Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Continue Statement</em>'.
   * @see com.rockwellcollins.atc.limp.ContinueStatement
   * @generated
   */
  EClass getContinueStatement();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Statement</em>'.
   * @see com.rockwellcollins.atc.limp.ReturnStatement
   * @generated
   */
  EClass getReturnStatement();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ElseBlock <em>Else Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else Block</em>'.
   * @see com.rockwellcollins.atc.limp.ElseBlock
   * @generated
   */
  EClass getElseBlock();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ElseBlock#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see com.rockwellcollins.atc.limp.ElseBlock#getBlock()
   * @see #getElseBlock()
   * @generated
   */
  EReference getElseBlock_Block();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ElseIf <em>Else If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else If</em>'.
   * @see com.rockwellcollins.atc.limp.ElseIf
   * @generated
   */
  EClass getElseIf();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ElseIf#getIfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Then Else</em>'.
   * @see com.rockwellcollins.atc.limp.ElseIf#getIfThenElse()
   * @see #getElseIf()
   * @generated
   */
  EReference getElseIf_IfThenElse();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.NoElse <em>No Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Else</em>'.
   * @see com.rockwellcollins.atc.limp.NoElse
   * @generated
   */
  EClass getNoElse();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseExpr
   * @generated
   */
  EClass getIfThenElseExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getCondExpr <em>Cond Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseExpr#getCondExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_CondExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getThenExpr <em>Then Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseExpr#getThenExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_ThenExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getElseExpr <em>Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IfThenElseExpr#getElseExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_ElseExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ChoiceExpr <em>Choice Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ChoiceExpr
   * @generated
   */
  EClass getChoiceExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ChoiceExpr#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see com.rockwellcollins.atc.limp.ChoiceExpr#getFirst()
   * @see #getChoiceExpr()
   * @generated
   */
  EReference getChoiceExpr_First();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ChoiceExpr#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second</em>'.
   * @see com.rockwellcollins.atc.limp.ChoiceExpr#getSecond()
   * @see #getChoiceExpr()
   * @generated
   */
  EReference getChoiceExpr_Second();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Expr</em>'.
   * @see com.rockwellcollins.atc.limp.BinaryExpr
   * @generated
   */
  EClass getBinaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.BinaryExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.rockwellcollins.atc.limp.BinaryExpr#getLeft()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.BinaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.atc.limp.BinaryExpr#getOp()
   * @see #getBinaryExpr()
   * @generated
   */
  EAttribute getBinaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.BinaryExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.rockwellcollins.atc.limp.BinaryExpr#getRight()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Right();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.UnaryNegationExpr <em>Unary Negation Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Negation Expr</em>'.
   * @see com.rockwellcollins.atc.limp.UnaryNegationExpr
   * @generated
   */
  EClass getUnaryNegationExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.UnaryNegationExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.UnaryNegationExpr#getExpr()
   * @see #getUnaryNegationExpr()
   * @generated
   */
  EReference getUnaryNegationExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.UnaryMinusExpr <em>Unary Minus Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Minus Expr</em>'.
   * @see com.rockwellcollins.atc.limp.UnaryMinusExpr
   * @generated
   */
  EClass getUnaryMinusExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.UnaryMinusExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.limp.UnaryMinusExpr#getExpr()
   * @see #getUnaryMinusExpr()
   * @generated
   */
  EReference getUnaryMinusExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordAccessExpr <em>Record Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Access Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RecordAccessExpr
   * @generated
   */
  EClass getRecordAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see com.rockwellcollins.atc.limp.RecordAccessExpr#getRecord()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Record();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field</em>'.
   * @see com.rockwellcollins.atc.limp.RecordAccessExpr#getField()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EAttribute getRecordAccessExpr_Field();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RecordUpdateExpr <em>Record Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Update Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RecordUpdateExpr
   * @generated
   */
  EClass getRecordUpdateExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.RecordUpdateExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see com.rockwellcollins.atc.limp.RecordUpdateExpr#getRecord()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EReference getRecordUpdateExpr_Record();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.RecordUpdateExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field</em>'.
   * @see com.rockwellcollins.atc.limp.RecordUpdateExpr#getField()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EAttribute getRecordUpdateExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.RecordUpdateExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.rockwellcollins.atc.limp.RecordUpdateExpr#getValue()
   * @see #getRecordUpdateExpr()
   * @generated
   */
  EReference getRecordUpdateExpr_Value();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ArrayAccessExpr <em>Array Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Access Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayAccessExpr
   * @generated
   */
  EClass getArrayAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ArrayAccessExpr#getArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayAccessExpr#getArray()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Array();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ArrayAccessExpr#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayAccessExpr#getIndex()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Index();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.ArrayUpdateExpr <em>Array Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Update Expr</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayUpdateExpr
   * @generated
   */
  EClass getArrayUpdateExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ArrayUpdateExpr#getAccess <em>Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Access</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayUpdateExpr#getAccess()
   * @see #getArrayUpdateExpr()
   * @generated
   */
  EReference getArrayUpdateExpr_Access();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.ArrayUpdateExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.rockwellcollins.atc.limp.ArrayUpdateExpr#getValue()
   * @see #getArrayUpdateExpr()
   * @generated
   */
  EReference getArrayUpdateExpr_Value();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.BooleanLiteralExpr <em>Boolean Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal Expr</em>'.
   * @see com.rockwellcollins.atc.limp.BooleanLiteralExpr
   * @generated
   */
  EClass getBooleanLiteralExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.BooleanLiteralExpr#getBoolVal <em>Bool Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool Val</em>'.
   * @see com.rockwellcollins.atc.limp.BooleanLiteralExpr#getBoolVal()
   * @see #getBooleanLiteralExpr()
   * @generated
   */
  EAttribute getBooleanLiteralExpr_BoolVal();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IntegerLiteralExpr <em>Integer Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IntegerLiteralExpr
   * @generated
   */
  EClass getIntegerLiteralExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.IntegerLiteralExpr#getIntVal <em>Int Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int Val</em>'.
   * @see com.rockwellcollins.atc.limp.IntegerLiteralExpr#getIntVal()
   * @see #getIntegerLiteralExpr()
   * @generated
   */
  EAttribute getIntegerLiteralExpr_IntVal();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IntegerWildCardExpr <em>Integer Wild Card Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Wild Card Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IntegerWildCardExpr
   * @generated
   */
  EClass getIntegerWildCardExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.RealLiteralExpr <em>Real Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal Expr</em>'.
   * @see com.rockwellcollins.atc.limp.RealLiteralExpr
   * @generated
   */
  EClass getRealLiteralExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.RealLiteralExpr#getRealVal <em>Real Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Real Val</em>'.
   * @see com.rockwellcollins.atc.limp.RealLiteralExpr#getRealVal()
   * @see #getRealLiteralExpr()
   * @generated
   */
  EAttribute getRealLiteralExpr_RealVal();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.StringLiteralExpr <em>String Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Expr</em>'.
   * @see com.rockwellcollins.atc.limp.StringLiteralExpr
   * @generated
   */
  EClass getStringLiteralExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.StringLiteralExpr#getStringVal <em>String Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Val</em>'.
   * @see com.rockwellcollins.atc.limp.StringLiteralExpr#getStringVal()
   * @see #getStringLiteralExpr()
   * @generated
   */
  EAttribute getStringLiteralExpr_StringVal();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.InitExpr <em>Init Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Expr</em>'.
   * @see com.rockwellcollins.atc.limp.InitExpr
   * @generated
   */
  EClass getInitExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.InitExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.atc.limp.InitExpr#getId()
   * @see #getInitExpr()
   * @generated
   */
  EReference getInitExpr_Id();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.SecondInit <em>Second Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Init</em>'.
   * @see com.rockwellcollins.atc.limp.SecondInit
   * @generated
   */
  EClass getSecondInit();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.SecondInit#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.atc.limp.SecondInit#getId()
   * @see #getSecondInit()
   * @generated
   */
  EReference getSecondInit_Id();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Expr</em>'.
   * @see com.rockwellcollins.atc.limp.IdExpr
   * @generated
   */
  EClass getIdExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.IdExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.atc.limp.IdExpr#getId()
   * @see #getIdExpr()
   * @generated
   */
  EReference getIdExpr_Id();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.FcnCallExpr <em>Fcn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fcn Call Expr</em>'.
   * @see com.rockwellcollins.atc.limp.FcnCallExpr
   * @generated
   */
  EClass getFcnCallExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.limp.FcnCallExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.atc.limp.FcnCallExpr#getId()
   * @see #getFcnCallExpr()
   * @generated
   */
  EReference getFcnCallExpr_Id();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.limp.FcnCallExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exprs</em>'.
   * @see com.rockwellcollins.atc.limp.FcnCallExpr#getExprs()
   * @see #getFcnCallExpr()
   * @generated
   */
  EReference getFcnCallExpr_Exprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see com.rockwellcollins.atc.limp.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.limp.TupleType#getTypeList <em>Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type List</em>'.
   * @see com.rockwellcollins.atc.limp.TupleType#getTypeList()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_TypeList();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.limp.FreshVariable <em>Fresh Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fresh Variable</em>'.
   * @see com.rockwellcollins.atc.limp.FreshVariable
   * @generated
   */
  EClass getFreshVariable();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.limp.FreshVariable#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.rockwellcollins.atc.limp.FreshVariable#getValue()
   * @see #getFreshVariable()
   * @generated
   */
  EAttribute getFreshVariable_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LimpFactory getLimpFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.SpecificationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__DECLARATIONS = eINSTANCE.getSpecification_Declarations();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.DeclarationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.CommentImpl <em>Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.CommentImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getComment()
     * @generated
     */
    EClass COMMENT = eINSTANCE.getComment();

    /**
     * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMENT__COMMENT = eINSTANCE.getComment_Comment();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ImportImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ExternalFunctionImpl <em>External Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ExternalFunctionImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExternalFunction()
     * @generated
     */
    EClass EXTERNAL_FUNCTION = eINSTANCE.getExternalFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_FUNCTION__NAME = eINSTANCE.getExternalFunction_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION__INPUTS = eINSTANCE.getExternalFunction_Inputs();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_FUNCTION__OUTPUT = eINSTANCE.getExternalFunction_Output();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ExternalProcedureImpl <em>External Procedure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ExternalProcedureImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExternalProcedure()
     * @generated
     */
    EClass EXTERNAL_PROCEDURE = eINSTANCE.getExternalProcedure();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_PROCEDURE__NAME = eINSTANCE.getExternalProcedure_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_PROCEDURE__INPUTS = eINSTANCE.getExternalProcedure_Inputs();

    /**
     * The meta object literal for the '<em><b>Outputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_PROCEDURE__OUTPUTS = eINSTANCE.getExternalProcedure_Outputs();

    /**
     * The meta object literal for the '<em><b>Attribute Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_PROCEDURE__ATTRIBUTE_BLOCK = eINSTANCE.getExternalProcedure_AttributeBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl <em>Local Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.LocalFunctionImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalFunction()
     * @generated
     */
    EClass LOCAL_FUNCTION = eINSTANCE.getLocalFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCAL_FUNCTION__NAME = eINSTANCE.getLocalFunction_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_FUNCTION__INPUTS = eINSTANCE.getLocalFunction_Inputs();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_FUNCTION__OUTPUT = eINSTANCE.getLocalFunction_Output();

    /**
     * The meta object literal for the '<em><b>Var Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_FUNCTION__VAR_BLOCK = eINSTANCE.getLocalFunction_VarBlock();

    /**
     * The meta object literal for the '<em><b>Equation Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_FUNCTION__EQUATION_BLOCK = eINSTANCE.getLocalFunction_EquationBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl <em>Local Procedure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.LocalProcedureImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalProcedure()
     * @generated
     */
    EClass LOCAL_PROCEDURE = eINSTANCE.getLocalProcedure();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCAL_PROCEDURE__NAME = eINSTANCE.getLocalProcedure_Name();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_PROCEDURE__INPUTS = eINSTANCE.getLocalProcedure_Inputs();

    /**
     * The meta object literal for the '<em><b>Outputs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_PROCEDURE__OUTPUTS = eINSTANCE.getLocalProcedure_Outputs();

    /**
     * The meta object literal for the '<em><b>Var Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_PROCEDURE__VAR_BLOCK = eINSTANCE.getLocalProcedure_VarBlock();

    /**
     * The meta object literal for the '<em><b>Attribute Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_PROCEDURE__ATTRIBUTE_BLOCK = eINSTANCE.getLocalProcedure_AttributeBlock();

    /**
     * The meta object literal for the '<em><b>Statementblock</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_PROCEDURE__STATEMENTBLOCK = eINSTANCE.getLocalProcedure_Statementblock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.TypeDeclarationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTypeDeclaration()
     * @generated
     */
    EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DECLARATION__NAME = eINSTANCE.getTypeDeclaration_Name();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.VarBlockImpl <em>Var Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.VarBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVarBlock()
     * @generated
     */
    EClass VAR_BLOCK = eINSTANCE.getVarBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.EnumTypeDefImpl <em>Enum Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.EnumTypeDefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumTypeDef()
     * @generated
     */
    EClass ENUM_TYPE_DEF = eINSTANCE.getEnumTypeDef();

    /**
     * The meta object literal for the '<em><b>Enumerations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_TYPE_DEF__ENUMERATIONS = eINSTANCE.getEnumTypeDef_Enumerations();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.EnumValueImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumValue()
     * @generated
     */
    EClass ENUM_VALUE = eINSTANCE.getEnumValue();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordTypeDefImpl <em>Record Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordTypeDefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordTypeDef()
     * @generated
     */
    EClass RECORD_TYPE_DEF = eINSTANCE.getRecordTypeDef();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE_DEF__FIELDS = eINSTANCE.getRecordTypeDef_Fields();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ArrayTypeDefImpl <em>Array Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ArrayTypeDefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayTypeDef()
     * @generated
     */
    EClass ARRAY_TYPE_DEF = eINSTANCE.getArrayTypeDef();

    /**
     * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE_DEF__BASE_TYPE = eINSTANCE.getArrayTypeDef_BaseType();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY_TYPE_DEF__SIZE = eINSTANCE.getArrayTypeDef_Size();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.AbstractTypeDefImpl <em>Abstract Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.AbstractTypeDefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAbstractTypeDef()
     * @generated
     */
    EClass ABSTRACT_TYPE_DEF = eINSTANCE.getAbstractTypeDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl <em>Record Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordFieldType()
     * @generated
     */
    EClass RECORD_FIELD_TYPE = eINSTANCE.getRecordFieldType();

    /**
     * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_FIELD_TYPE__FIELD_NAME = eINSTANCE.getRecordFieldType_FieldName();

    /**
     * The meta object literal for the '<em><b>Field Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_TYPE__FIELD_TYPE = eINSTANCE.getRecordFieldType_FieldType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ConstantDeclarationImpl <em>Constant Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ConstantDeclarationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getConstantDeclaration()
     * @generated
     */
    EClass CONSTANT_DECLARATION = eINSTANCE.getConstantDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DECLARATION__TYPE = eINSTANCE.getConstantDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DECLARATION__EXPR = eINSTANCE.getConstantDeclaration_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.GlobalDeclarationImpl <em>Global Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.GlobalDeclarationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getGlobalDeclaration()
     * @generated
     */
    EClass GLOBAL_DECLARATION = eINSTANCE.getGlobalDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GLOBAL_DECLARATION__TYPE = eINSTANCE.getGlobalDeclaration_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.VariableRefImpl <em>Variable Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.VariableRefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVariableRef()
     * @generated
     */
    EClass VARIABLE_REF = eINSTANCE.getVariableRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_REF__NAME = eINSTANCE.getVariableRef_Name();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.InputArgListImpl <em>Input Arg List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.InputArgListImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInputArgList()
     * @generated
     */
    EClass INPUT_ARG_LIST = eINSTANCE.getInputArgList();

    /**
     * The meta object literal for the '<em><b>Input Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ARG_LIST__INPUT_ARGS = eINSTANCE.getInputArgList_InputArgs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.InputArgImpl <em>Input Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.InputArgImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInputArg()
     * @generated
     */
    EClass INPUT_ARG = eINSTANCE.getInputArg();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ARG__TYPE = eINSTANCE.getInputArg_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.LocalArgImpl <em>Local Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.LocalArgImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLocalArg()
     * @generated
     */
    EClass LOCAL_ARG = eINSTANCE.getLocalArg();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_ARG__TYPE = eINSTANCE.getLocalArg_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.OutputArgListImpl <em>Output Arg List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.OutputArgListImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getOutputArgList()
     * @generated
     */
    EClass OUTPUT_ARG_LIST = eINSTANCE.getOutputArgList();

    /**
     * The meta object literal for the '<em><b>Output Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_ARG_LIST__OUTPUT_ARGS = eINSTANCE.getOutputArgList_OutputArgs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.OutputArgImpl <em>Output Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.OutputArgImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getOutputArg()
     * @generated
     */
    EClass OUTPUT_ARG = eINSTANCE.getOutputArg();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_ARG__TYPE = eINSTANCE.getOutputArg_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.TypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.AttributeBlockImpl <em>Attribute Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.AttributeBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAttributeBlock()
     * @generated
     */
    EClass ATTRIBUTE_BLOCK = eINSTANCE.getAttributeBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.AttributeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.PreconditionImpl <em>Precondition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.PreconditionImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getPrecondition()
     * @generated
     */
    EClass PRECONDITION = eINSTANCE.getPrecondition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRECONDITION__NAME = eINSTANCE.getPrecondition_Name();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION__EXPR = eINSTANCE.getPrecondition_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.PostconditionImpl <em>Postcondition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.PostconditionImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getPostcondition()
     * @generated
     */
    EClass POSTCONDITION = eINSTANCE.getPostcondition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POSTCONDITION__NAME = eINSTANCE.getPostcondition_Name();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTCONDITION__EXPR = eINSTANCE.getPostcondition_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.DefineUseRefImpl <em>Define Use Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.DefineUseRefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDefineUseRef()
     * @generated
     */
    EClass DEFINE_USE_REF = eINSTANCE.getDefineUseRef();

    /**
     * The meta object literal for the '<em><b>Reference Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_USE_REF__REFERENCE_EXPR = eINSTANCE.getDefineUseRef_ReferenceExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.DefineImpl <em>Define</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.DefineImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getDefine()
     * @generated
     */
    EClass DEFINE = eINSTANCE.getDefine();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE__ELEMENTS = eINSTANCE.getDefine_Elements();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.UsesImpl <em>Uses</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.UsesImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUses()
     * @generated
     */
    EClass USES = eINSTANCE.getUses();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USES__ELEMENTS = eINSTANCE.getUses_Elements();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.StatementBlockImpl <em>Statement Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.StatementBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStatementBlock()
     * @generated
     */
    EClass STATEMENT_BLOCK = eINSTANCE.getStatementBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT_BLOCK__STATEMENTS = eINSTANCE.getStatementBlock_Statements();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.StatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.VoidStatementImpl <em>Void Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.VoidStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVoidStatement()
     * @generated
     */
    EClass VOID_STATEMENT = eINSTANCE.getVoidStatement();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VOID_STATEMENT__EXPR = eINSTANCE.getVoidStatement_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAssignmentStatement()
     * @generated
     */
    EClass ASSIGNMENT_STATEMENT = eINSTANCE.getAssignmentStatement();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_STATEMENT__IDS = eINSTANCE.getAssignmentStatement_Ids();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_STATEMENT__RHS = eINSTANCE.getAssignmentStatement_Rhs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl <em>If Then Else Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIfThenElseStatement()
     * @generated
     */
    EClass IF_THEN_ELSE_STATEMENT = eINSTANCE.getIfThenElseStatement();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_STATEMENT__COND = eINSTANCE.getIfThenElseStatement_Cond();

    /**
     * The meta object literal for the '<em><b>Then Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_STATEMENT__THEN_BLOCK = eINSTANCE.getIfThenElseStatement_ThenBlock();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_STATEMENT__ELSE = eINSTANCE.getIfThenElseStatement_Else();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ElseImpl <em>Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ElseImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElse()
     * @generated
     */
    EClass ELSE = eINSTANCE.getElse();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.WhileStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getWhileStatement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__COND = eINSTANCE.getWhileStatement_Cond();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__BLOCK = eINSTANCE.getWhileStatement_Block();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl <em>For Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ForStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getForStatement()
     * @generated
     */
    EClass FOR_STATEMENT = eINSTANCE.getForStatement();

    /**
     * The meta object literal for the '<em><b>Init Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__INIT_STATEMENT = eINSTANCE.getForStatement_InitStatement();

    /**
     * The meta object literal for the '<em><b>Limit Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__LIMIT_EXPR = eINSTANCE.getForStatement_LimitExpr();

    /**
     * The meta object literal for the '<em><b>Increment Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__INCREMENT_STATEMENT = eINSTANCE.getForStatement_IncrementStatement();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__BLOCK = eINSTANCE.getForStatement_Block();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.LabelStatementImpl <em>Label Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.LabelStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getLabelStatement()
     * @generated
     */
    EClass LABEL_STATEMENT = eINSTANCE.getLabelStatement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABEL_STATEMENT__NAME = eINSTANCE.getLabelStatement_Name();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.GotoStatementImpl <em>Goto Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.GotoStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getGotoStatement()
     * @generated
     */
    EClass GOTO_STATEMENT = eINSTANCE.getGotoStatement();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOTO_STATEMENT__LABEL = eINSTANCE.getGotoStatement_Label();

    /**
     * The meta object literal for the '<em><b>When Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOTO_STATEMENT__WHEN_EXPR = eINSTANCE.getGotoStatement_WhenExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.EquationBlockImpl <em>Equation Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.EquationBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEquationBlock()
     * @generated
     */
    EClass EQUATION_BLOCK = eINSTANCE.getEquationBlock();

    /**
     * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUATION_BLOCK__EQUATIONS = eINSTANCE.getEquationBlock_Equations();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.EquationImpl <em>Equation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.EquationImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEquation()
     * @generated
     */
    EClass EQUATION = eINSTANCE.getEquation();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IdListImpl <em>Id List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IdListImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIdList()
     * @generated
     */
    EClass ID_LIST = eINSTANCE.getIdList();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_LIST__IDS = eINSTANCE.getIdList_Ids();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.FunctionRefImpl <em>Function Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.FunctionRefImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFunctionRef()
     * @generated
     */
    EClass FUNCTION_REF = eINSTANCE.getFunctionRef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ArrayExprImpl <em>Array Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ArrayExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayExpr()
     * @generated
     */
    EClass ARRAY_EXPR = eINSTANCE.getArrayExpr();

    /**
     * The meta object literal for the '<em><b>Array Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_EXPR__ARRAY_DEFINITION = eINSTANCE.getArrayExpr_ArrayDefinition();

    /**
     * The meta object literal for the '<em><b>Expr List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_EXPR__EXPR_LIST = eINSTANCE.getArrayExpr_ExprList();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordExprImpl <em>Record Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordExpr()
     * @generated
     */
    EClass RECORD_EXPR = eINSTANCE.getRecordExpr();

    /**
     * The meta object literal for the '<em><b>Record Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__RECORD_DEFINITION = eINSTANCE.getRecordExpr_RecordDefinition();

    /**
     * The meta object literal for the '<em><b>Field Expr List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__FIELD_EXPR_LIST = eINSTANCE.getRecordExpr_FieldExprList();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordFieldExpr()
     * @generated
     */
    EClass RECORD_FIELD_EXPR = eINSTANCE.getRecordFieldExpr();

    /**
     * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_FIELD_EXPR__FIELD_NAME = eINSTANCE.getRecordFieldExpr_FieldName();

    /**
     * The meta object literal for the '<em><b>Field Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__FIELD_EXPR = eINSTANCE.getRecordFieldExpr_FieldExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ExprListImpl <em>Expr List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ExprListImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getExprList()
     * @generated
     */
    EClass EXPR_LIST = eINSTANCE.getExprList();

    /**
     * The meta object literal for the '<em><b>Expr List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_LIST__EXPR_LIST = eINSTANCE.getExprList_ExprList();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.TypeAliasImpl <em>Type Alias</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.TypeAliasImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTypeAlias()
     * @generated
     */
    EClass TYPE_ALIAS = eINSTANCE.getTypeAlias();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ALIAS__TYPE = eINSTANCE.getTypeAlias_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.SomeVarBlockImpl <em>Some Var Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.SomeVarBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSomeVarBlock()
     * @generated
     */
    EClass SOME_VAR_BLOCK = eINSTANCE.getSomeVarBlock();

    /**
     * The meta object literal for the '<em><b>Locals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOME_VAR_BLOCK__LOCALS = eINSTANCE.getSomeVarBlock_Locals();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.NoVarBlockImpl <em>No Var Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.NoVarBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoVarBlock()
     * @generated
     */
    EClass NO_VAR_BLOCK = eINSTANCE.getNoVarBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.VoidTypeImpl <em>Void Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.VoidTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getVoidType()
     * @generated
     */
    EClass VOID_TYPE = eINSTANCE.getVoidType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.BoolTypeImpl <em>Bool Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.BoolTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBoolType()
     * @generated
     */
    EClass BOOL_TYPE = eINSTANCE.getBoolType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IntegerTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerType()
     * @generated
     */
    EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RealTypeImpl <em>Real Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RealTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRealType()
     * @generated
     */
    EClass REAL_TYPE = eINSTANCE.getRealType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.StringTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.EnumTypeImpl <em>Enum Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.EnumTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getEnumType()
     * @generated
     */
    EClass ENUM_TYPE = eINSTANCE.getEnumType();

    /**
     * The meta object literal for the '<em><b>Enum Def</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_TYPE__ENUM_DEF = eINSTANCE.getEnumType_EnumDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordTypeImpl <em>Record Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordType()
     * @generated
     */
    EClass RECORD_TYPE = eINSTANCE.getRecordType();

    /**
     * The meta object literal for the '<em><b>Record Def</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE__RECORD_DEF = eINSTANCE.getRecordType_RecordDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ArrayTypeImpl <em>Array Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ArrayTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayType()
     * @generated
     */
    EClass ARRAY_TYPE = eINSTANCE.getArrayType();

    /**
     * The meta object literal for the '<em><b>Array Def</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE__ARRAY_DEF = eINSTANCE.getArrayType_ArrayDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.AbstractTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getAbstractType()
     * @generated
     */
    EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

    /**
     * The meta object literal for the '<em><b>Abstract Def</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_TYPE__ABSTRACT_DEF = eINSTANCE.getAbstractType_AbstractDef();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.NamedTypeImpl <em>Named Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.NamedTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNamedType()
     * @generated
     */
    EClass NAMED_TYPE = eINSTANCE.getNamedType();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TYPE__ALIAS = eINSTANCE.getNamedType_Alias();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.SomeAttributeBlockImpl <em>Some Attribute Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.SomeAttributeBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSomeAttributeBlock()
     * @generated
     */
    EClass SOME_ATTRIBUTE_BLOCK = eINSTANCE.getSomeAttributeBlock();

    /**
     * The meta object literal for the '<em><b>Attribute List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST = eINSTANCE.getSomeAttributeBlock_AttributeList();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.NoAttributeBlockImpl <em>No Attribute Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.NoAttributeBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoAttributeBlock()
     * @generated
     */
    EClass NO_ATTRIBUTE_BLOCK = eINSTANCE.getNoAttributeBlock();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.BreakStatementImpl <em>Break Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.BreakStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBreakStatement()
     * @generated
     */
    EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ContinueStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getContinueStatement()
     * @generated
     */
    EClass CONTINUE_STATEMENT = eINSTANCE.getContinueStatement();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ReturnStatementImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getReturnStatement()
     * @generated
     */
    EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ElseBlockImpl <em>Else Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ElseBlockImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElseBlock()
     * @generated
     */
    EClass ELSE_BLOCK = eINSTANCE.getElseBlock();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_BLOCK__BLOCK = eINSTANCE.getElseBlock_Block();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ElseIfImpl <em>Else If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ElseIfImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getElseIf()
     * @generated
     */
    EClass ELSE_IF = eINSTANCE.getElseIf();

    /**
     * The meta object literal for the '<em><b>If Then Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_IF__IF_THEN_ELSE = eINSTANCE.getElseIf_IfThenElse();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.NoElseImpl <em>No Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.NoElseImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getNoElse()
     * @generated
     */
    EClass NO_ELSE = eINSTANCE.getNoElse();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIfThenElseExpr()
     * @generated
     */
    EClass IF_THEN_ELSE_EXPR = eINSTANCE.getIfThenElseExpr();

    /**
     * The meta object literal for the '<em><b>Cond Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__COND_EXPR = eINSTANCE.getIfThenElseExpr_CondExpr();

    /**
     * The meta object literal for the '<em><b>Then Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__THEN_EXPR = eINSTANCE.getIfThenElseExpr_ThenExpr();

    /**
     * The meta object literal for the '<em><b>Else Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__ELSE_EXPR = eINSTANCE.getIfThenElseExpr_ElseExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ChoiceExprImpl <em>Choice Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ChoiceExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getChoiceExpr()
     * @generated
     */
    EClass CHOICE_EXPR = eINSTANCE.getChoiceExpr();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE_EXPR__FIRST = eINSTANCE.getChoiceExpr_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE_EXPR__SECOND = eINSTANCE.getChoiceExpr_Second();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.BinaryExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBinaryExpr()
     * @generated
     */
    EClass BINARY_EXPR = eINSTANCE.getBinaryExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__LEFT = eINSTANCE.getBinaryExpr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_EXPR__OP = eINSTANCE.getBinaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__RIGHT = eINSTANCE.getBinaryExpr_Right();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.UnaryNegationExprImpl <em>Unary Negation Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.UnaryNegationExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUnaryNegationExpr()
     * @generated
     */
    EClass UNARY_NEGATION_EXPR = eINSTANCE.getUnaryNegationExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_NEGATION_EXPR__EXPR = eINSTANCE.getUnaryNegationExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.UnaryMinusExprImpl <em>Unary Minus Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.UnaryMinusExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getUnaryMinusExpr()
     * @generated
     */
    EClass UNARY_MINUS_EXPR = eINSTANCE.getUnaryMinusExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_MINUS_EXPR__EXPR = eINSTANCE.getUnaryMinusExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordAccessExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordAccessExpr()
     * @generated
     */
    EClass RECORD_ACCESS_EXPR = eINSTANCE.getRecordAccessExpr();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__RECORD = eINSTANCE.getRecordAccessExpr_Record();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_ACCESS_EXPR__FIELD = eINSTANCE.getRecordAccessExpr_Field();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl <em>Record Update Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRecordUpdateExpr()
     * @generated
     */
    EClass RECORD_UPDATE_EXPR = eINSTANCE.getRecordUpdateExpr();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_UPDATE_EXPR__RECORD = eINSTANCE.getRecordUpdateExpr_Record();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_UPDATE_EXPR__FIELD = eINSTANCE.getRecordUpdateExpr_Field();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_UPDATE_EXPR__VALUE = eINSTANCE.getRecordUpdateExpr_Value();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ArrayAccessExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayAccessExpr()
     * @generated
     */
    EClass ARRAY_ACCESS_EXPR = eINSTANCE.getArrayAccessExpr();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__ARRAY = eINSTANCE.getArrayAccessExpr_Array();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__INDEX = eINSTANCE.getArrayAccessExpr_Index();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.ArrayUpdateExprImpl <em>Array Update Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.ArrayUpdateExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getArrayUpdateExpr()
     * @generated
     */
    EClass ARRAY_UPDATE_EXPR = eINSTANCE.getArrayUpdateExpr();

    /**
     * The meta object literal for the '<em><b>Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_UPDATE_EXPR__ACCESS = eINSTANCE.getArrayUpdateExpr_Access();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_UPDATE_EXPR__VALUE = eINSTANCE.getArrayUpdateExpr_Value();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.BooleanLiteralExprImpl <em>Boolean Literal Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.BooleanLiteralExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getBooleanLiteralExpr()
     * @generated
     */
    EClass BOOLEAN_LITERAL_EXPR = eINSTANCE.getBooleanLiteralExpr();

    /**
     * The meta object literal for the '<em><b>Bool Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL_EXPR__BOOL_VAL = eINSTANCE.getBooleanLiteralExpr_BoolVal();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IntegerLiteralExprImpl <em>Integer Literal Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IntegerLiteralExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerLiteralExpr()
     * @generated
     */
    EClass INTEGER_LITERAL_EXPR = eINSTANCE.getIntegerLiteralExpr();

    /**
     * The meta object literal for the '<em><b>Int Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_LITERAL_EXPR__INT_VAL = eINSTANCE.getIntegerLiteralExpr_IntVal();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IntegerWildCardExprImpl <em>Integer Wild Card Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IntegerWildCardExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIntegerWildCardExpr()
     * @generated
     */
    EClass INTEGER_WILD_CARD_EXPR = eINSTANCE.getIntegerWildCardExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.RealLiteralExprImpl <em>Real Literal Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.RealLiteralExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getRealLiteralExpr()
     * @generated
     */
    EClass REAL_LITERAL_EXPR = eINSTANCE.getRealLiteralExpr();

    /**
     * The meta object literal for the '<em><b>Real Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL_EXPR__REAL_VAL = eINSTANCE.getRealLiteralExpr_RealVal();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.StringLiteralExprImpl <em>String Literal Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.StringLiteralExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getStringLiteralExpr()
     * @generated
     */
    EClass STRING_LITERAL_EXPR = eINSTANCE.getStringLiteralExpr();

    /**
     * The meta object literal for the '<em><b>String Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL_EXPR__STRING_VAL = eINSTANCE.getStringLiteralExpr_StringVal();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.InitExprImpl <em>Init Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.InitExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getInitExpr()
     * @generated
     */
    EClass INIT_EXPR = eINSTANCE.getInitExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_EXPR__ID = eINSTANCE.getInitExpr_Id();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.SecondInitImpl <em>Second Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.SecondInitImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getSecondInit()
     * @generated
     */
    EClass SECOND_INIT = eINSTANCE.getSecondInit();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_INIT__ID = eINSTANCE.getSecondInit_Id();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.IdExprImpl <em>Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.IdExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getIdExpr()
     * @generated
     */
    EClass ID_EXPR = eINSTANCE.getIdExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_EXPR__ID = eINSTANCE.getIdExpr_Id();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.FcnCallExprImpl <em>Fcn Call Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.FcnCallExprImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFcnCallExpr()
     * @generated
     */
    EClass FCN_CALL_EXPR = eINSTANCE.getFcnCallExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FCN_CALL_EXPR__ID = eINSTANCE.getFcnCallExpr_Id();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FCN_CALL_EXPR__EXPRS = eINSTANCE.getFcnCallExpr_Exprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.TupleTypeImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getTupleType()
     * @generated
     */
    EClass TUPLE_TYPE = eINSTANCE.getTupleType();

    /**
     * The meta object literal for the '<em><b>Type List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE__TYPE_LIST = eINSTANCE.getTupleType_TypeList();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.limp.impl.FreshVariableImpl <em>Fresh Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.limp.impl.FreshVariableImpl
     * @see com.rockwellcollins.atc.limp.impl.LimpPackageImpl#getFreshVariable()
     * @generated
     */
    EClass FRESH_VARIABLE = eINSTANCE.getFreshVariable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FRESH_VARIABLE__VALUE = eINSTANCE.getFreshVariable_Value();

  }

} //LimpPackage
